public class SubstringExtractor {

    public static String extractH1Content(String str) {
        String emptyString = "";
        String startTag = "<h1>";
        String endTag = "</h1>";

        //find the position of the start tag
        int indexStart = str.indexOf(startTag);

        // return empty string if start tag not found
        if (indexStart == -1) {
            return emptyString;
        }

        // find the position of the end tag
        int indexEnd = str.indexOf(endTag);

        //extract substring between start and end tag
        return str.substring(indexStart, indexEnd);
    }
}

