package edu.nyu.cs9053.homework6;
import java.lang.reflect.InvocationTargetException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * User: blangel
 * Date: 10/5/14
 * Time: 6:21 PM
 */
public class CenterDiseaseControl {
    private static final long SEED = 3843726185L;
    private static final String SMALLPOX_ANTIDOTE = "1110";
    private static final String EBOLA_ANTIDOTE = "0101";
    private static final String SARS_ANTIDOTE = "0001";
    private static final String H1N1_ANTIDOTE = "10101001101101101001";
    public static void main(String[] args) {
        if ((args == null) || (args.length != 1)) {
            throw new AssertionError("Please specify your NetID");
        }
        String netId = args[0];
        CenterDiseaseControl centerDiseaseControl = new CenterDiseaseControl(netId);
        Population population = new Population();
        if (centerDiseaseControl.areDiseasesCured(population)) {
            System.out.printf("Congrats! You cured the epidemic!");
        } else {
            System.out.printf("Sadly, the epidemic still spreads...");
        }
    }

    private final long id;

    public CenterDiseaseControl(String id) {
        this.id = CRC32s.crc32(id);
        
    }

    public boolean areDiseasesCured(Population population) {
        Map<Disease, String> infections = getInfections(population);
        Map<Disease, String> cures = getCures();
        if (infections.isEmpty() || cures.isEmpty()) {
            throw new IllegalStateException("Not properly setup");
        }
        for (String value : infections.values()) {
            if ("".equals(value)) {

                throw new IllegalStateException("Not properly setup");
            }
        }
        for (Disease disease : Disease.values()) {
            String infection = infections.get(disease);
            String cure = cures.get(disease);
            if ((infection == null) || (cure == null)) {
                throw new IllegalStateException("Infection or cure not found.");
            }
            Pattern pattern = Pattern.compile(String.format(".*%s.*", cure));
            Matcher matcher = pattern.matcher(infection);
            if (!matcher.find()) {
                return false;
            }
        }
        return true;
    }

    @Vaccine(cures = Disease.SmallPox , seed = SEED , antidote=SMALLPOX_ANTIDOTE )public String getSmallPoxCure() {
        String idAsBinary = getIdAsBinary();
        return idAsBinary.substring(0, 4);
    }

    @Vaccine(cures = Disease.Ebola , seed = SEED , antidote=EBOLA_ANTIDOTE )public String getEbolaCure() {
        String idAsBinary = getIdAsBinary();
        return idAsBinary.substring(4, 8);
    }

    @Vaccine(cures = Disease.Sars , seed = SEED , antidote=SARS_ANTIDOTE )public String getSarsCure() {
        String idAsBinary = getIdAsBinary();
        return idAsBinary.substring(8, 12);
    }

    @Vaccine(cures = Disease.H1N1 , seed = SEED , antidote=H1N1_ANTIDOTE)public String getH1N1Cure() {
        String idAsBinary = getIdAsBinary();
        return idAsBinary.substring(12);
    }

    private Map<Disease, String> getInfections(Population population) {
        Method[] methods = Population.class.getDeclaredMethods();
        Map<Disease, String> diseases = new HashMap<>();
        for (Method method : methods) {
            if (method.isAnnotationPresent(Infection.class)) {
                
                Annotation annotaion=method.getAnnotation(Infection.class);
                Infection infection = (Infection)  annotaion;
                Disease disease = infection.cause();
                // TODO - uncomment and fix
                String result = ""; // 
                try{
                   result=  (String) method.invoke(population);
                   
                }
                catch ( IllegalAccessException | InvocationTargetException e){
                    System.out.println(e.getMessage());
                }
                if (!"".equals(result)) {
                    diseases.put(disease, result);
                }
            }
        }
        return diseases;
    }

    private Map<Disease, String> getCures() {
        Method[] centerDiseaseControlMethods = CenterDiseaseControl.class.getDeclaredMethods();
        Map<Disease, String> cures = new HashMap<>(Disease.values().length);
        for (Method method : centerDiseaseControlMethods) {
            if (method.isAnnotationPresent(Vaccine.class)) {
                Vaccine vaccine = method.getAnnotation(Vaccine.class);
                Disease disease = vaccine.cures();
                // TODO - uncomment and fix
                String result = ""; // (String) method.invoke(this);
                try{
                   result=  (String) method.invoke(this);
                }
                catch ( IllegalAccessException | InvocationTargetException e){
                      System.out.println(e.getMessage());
                }
                if (!"".equals(result) && (vaccine.seed() == id) && (vaccine.antidote().equals(result))) {
                    
                    cures.put(disease, result);
                }
            }
        }
        return cures;
    }

    private String getIdAsBinary() {
        String result= String.format("%16s", Long.toBinaryString(id)).replace(' ', '0');
        
        return result;
    }

}
