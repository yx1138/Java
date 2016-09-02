package edu.nyu.cs9053.randomizer;

import net.ocheyedan.Emoji;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

/**
 * User: blangel
 * Date: 9/2/16
 * Time: 9:29 AM
 */
public class Randomizer {

    public static void main(String[] args) {
        if ((args == null) || (args.length != 2)) {
            throw new IllegalArgumentException("Must provide a file to user ids and number of user ids to select");
        }
        String filePath = args[0];
        int numberToSelect = Integer.valueOf(args[1]);
        List<String> userIds = load(filePath);
        Randomizer randomizer = new Randomizer(numberToSelect, userIds);
        randomizer.process();
    }

    private static List<String> load(String filePath) {
        try {
            return Files.readAllLines(Paths.get(filePath), StandardCharsets.UTF_8);
        } catch (IOException ioe) {
            throw new AssertionError(ioe);
        }
    }

    private final int numberToSelect;

    private final List<String> studentIds;

    private final List<Emoji> emojis;

    private final Random random;

    public Randomizer(int numberToSelect, List<String> studentIds) {
        this(numberToSelect, studentIds, new Random());
    }

    Randomizer(int numberToSelect, List<String> studentIds, Random random) {
        if ((studentIds == null) || (random == null)) {
            throw new IllegalArgumentException("Values may not be null");
        } else if (studentIds.size() > Emoji.values().length) {
            throw new AssertionError("More students than Emojis! Need to generate more Emoji");
        } else if (studentIds.size() < numberToSelect) {
            throw new IllegalArgumentException("Cannot select more than students available");
        }
        this.numberToSelect = numberToSelect;
        this.studentIds = new ArrayList<>(studentIds);
        this.emojis = Arrays.asList(Emoji.values());
        this.random = random;
        shuffle();
    }

    private void shuffle() {
        Collections.shuffle(studentIds);
        Collections.shuffle(emojis);
    }

    public void process() {
        Map<String, Emoji> userEmojiMapping = new HashMap<>(studentIds.size(), 1.0f);
        IntStream.range(0, studentIds.size()).forEach(index -> userEmojiMapping.put(studentIds.get(index), emojis.get(index)));
        /**
         * Line 66 would be written as following in Java 1.7 and below
         *
         * for (int i = 0; i < studentIds.size(); i++) {
         *     userEmojiMapping.put(studentIds.get(i), emojis.get(i));
         * }
         */
        List<Integer> potentialIndices = IntStream.range(0, studentIds.size()).boxed().collect(toList());
        /**
         * Line 81 would be written as following in Java 1.7 and below
         *
         * List<Integer> potentialIndices = new ArrayList<>(studentIds.size());
         *     for (int i = 0; i < studentIds.size(); i++) {
         *     potentialIndices.add(i);
         * }
         */
        List<String> randomlySelectedStudents = IntStream.range(0, numberToSelect)
                .map(index -> random.nextInt(potentialIndices.size()))
                .map(potentialIndices::remove)
                .mapToObj(studentIds::get)
                .collect(toList());
        /**
         * Lines 90-94 would be written as following in Java 1.7 and below (caveat 'double diamond' only
         * available in 1.7 and above and generics only in 1.5 and above)
         *
         * List<String> randomlySelectedStudents = new ArrayList<>(numberToSelect);
         * for (int i = 0; i < numberToSelect; i++) {
         *     int index = random.nextInt(potentialIndices.size());
         *     int randomIndex = potentialIndices.remove(index);
         *     String userId = studentIds.get(randomIndex);
         *     randomlySelectedStudents.add(userId);
         * }
         */
        randomlySelectedStudents
                .stream().map(userEmojiMapping::get)
                .forEach(emoji -> System.out.printf("Student associated with  %s  [ %s ] must review!%n", emoji.toString(), emoji.name()));
        /**
         * Lines 107-109 would be written as following in Java 1.7 and below (caveat for-each loop only available
         * in 1.5 and above and printf style printing only available in 1.5 and above)
         *
         * for (String randomlySelectedUser : randomlySelectedStudents) {
         *     Emoji emoji = userEmojiMapping.get(randomlySelectedUser);
         *     System.out.printf("Student associated with %s [ %s ] must review!%n", emoji.toString(), emoji.name());
         * }
         */
        StringBuilder buffer = new StringBuilder(String.format("Id,Emoji%n"));
        userEmojiMapping.forEach((key, value) -> buffer.append(String.format("%s,%s%n", key, value.name())));
        /**
         * Line 121 would be written as following in Java 1.7 and below
         *
         * for (Map.Entry<String, Emoji> entry : userEmojiMapping.entrySet()) {
         *     buffer.append(String.format("%s,%s%n", entry.getKey(), entry.getValue().name());
         * }
         */
        String mappingText = buffer.toString();
        String outputFile = createOutputFileName();
        try {
            Files.write(Paths.get(outputFile), mappingText.getBytes(StandardCharsets.UTF_8),
                    StandardOpenOption.WRITE, StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
        } catch (IOException ioe) {
            throw new AssertionError(ioe);
        }
    }

    private String createOutputFileName() {
        SimpleDateFormat formatter = new SimpleDateFormat("MM-dd HH:mm:ss");
        String label = formatter.format(new Date());
        return String.format("%s.reviewers", label);
    }

}
