package se.mehdi.securewebapp.util;
//Använde en statisk metod "Anonymize" som tar e-postadress som argument och retunerar en anonymiserad version av e-post. man kan säga att den skydda användarensintegritet.
//MaskingUtils-klassen behöver skapas. man kan anropa metoden direkt med MaskingUtils.anonymize(email).
//Syftet: Syftet med MaskingUtils-klassen är att skydda användarnas integritet genom att anonymisera deras e-postadresser.Den används för att förhindra att fullständiga e-postadresser exponeras, till exempel vid loggning, felmeddelanden, eller andra ställen där e-postadresser kan visas.
public class MaskingUtils {
    public static String anonymize(String email) {
        String[] parts = email.split("@");
        if (parts.length > 1) {
            String name = parts[0];
            if (name.length() > 1) {
                return name.charAt(0) + "*****" + name.charAt(name.length() - 1) + "@" + parts[1];
            }
            return "*****@" + parts[1];
        }
        return "*****";
    }
}
