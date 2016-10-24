package edu.nyu.cs9053.homework6;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Random;
import java.util.UUID;
import java.util.regex.Pattern;

/**
 * User: blangel
 * Date: 10/5/14
 * Time: 6:58 PM
 */
public class SpreadEpidemic {

    public static void main(String[] args) {
        if ((args == null) || (args.length != 1)) {
            throw new AssertionError("Please specify your NetID");
        }
        String netId = args[0];
        long id = CRC32s.crc32(netId);
        SpreadEpidemic spreadEpidemic = new SpreadEpidemic(id);
        try {
            spreadEpidemic.spread();
        } catch (IOException ioe) {
            throw new AssertionError(ioe);
        }
    }

    private final long id;

    public SpreadEpidemic(long id) {
        this.id = id;
    }

    public void spread() throws IOException {
        Pattern pattern = Pattern.compile(Pattern.quote("// TODO - EPIDEMIC SEED"));
        StringBuilder buffer = new StringBuilder();
        List<String> lines = Files.readAllLines(Paths.get("src/main/java/edu/nyu/cs9053/homework6/Population.java"), Charset.defaultCharset());
        for (String line : lines) {
            if (pattern.matcher(line).find()) {
                buffer.append(getDiseaseMethod(Disease.SmallPox, getSmallPoxCure()));
                buffer.append(getDiseaseMethod(Disease.Ebola, getEbolaCure()));
                buffer.append(getDiseaseMethod(Disease.Sars, getSarsCure()));
                buffer.append(getDiseaseMethod(Disease.H1N1, getH1N1Cure()));
            } else {
                buffer.append(line);
            }
            buffer.append('\n');
        }
        try (FileWriter writer = new FileWriter("src/main/java/edu/nyu/cs9053/homework6/Population.java", false)) {
            writer.write(buffer.toString());
            writer.flush();
        }

    }

    private String getDiseaseMethod(Disease disease, String cure) {
        int position = new Random().nextInt(4);
        String value;
        switch (position) {
            case 0:
                value = String.format("%s%s%s%s", cure, UUID.randomUUID().toString(), UUID.randomUUID().toString(),
                        UUID.randomUUID().toString());
                break;
            case 1:
                value = String.format("%s%s%s%s", UUID.randomUUID().toString(), cure, UUID.randomUUID().toString(),
                        UUID.randomUUID().toString());
                break;
            case 2:
                value = String.format("%s%s%s%s", UUID.randomUUID().toString(), UUID.randomUUID().toString(), cure,
                        UUID.randomUUID().toString());
                break;
            case 3:
                value = String.format("%s%s%s%s", UUID.randomUUID().toString(), UUID.randomUUID().toString(),
                        UUID.randomUUID().toString(), cure);
                break;
            default:
                throw new AssertionError();

        }
        return String.format("\n    @Infection(cause = Disease.%s) public String getInfected%s() {\n        return \"%s\";\n    }\n",
                disease.name(), disease.name(), value);
    }

    private String getSmallPoxCure() {
        String idAsBinary = getIdAsBinary();
        return idAsBinary.substring(0, 4);
    }

    private String getEbolaCure() {
        String idAsBinary = getIdAsBinary();
        return idAsBinary.substring(4, 8);
    }

    private String getSarsCure() {
        String idAsBinary = getIdAsBinary();
        return idAsBinary.substring(8, 12);
    }

    private String getH1N1Cure() {
        String idAsBinary = getIdAsBinary();
        return idAsBinary.substring(12);
    }

    private String getIdAsBinary() {
        return String.format("%16s", Long.toBinaryString(id)).replace(' ', '0');
    }

}