package week1;

import java.util.HashMap;
import java.util.Map;

public class LukesProgram {

    public static void main(String[] args) {
        new DNAInfo();
    }

    private String applyMap(HashMap<Character, String> map, String in) {
        StringBuilder out = new StringBuilder(in);

        for(int i=0; i<out.length(); i++) {
            if(map.containsKey(out.charAt(i))) {
                out.replace(i, i+1, map.get(out.charAt(i)));
            }
        }

        return out.toString();
    }

    public String dnaToMRNA(String dna) {
        return applyMap(DNAToMRNAMap(), dna);
    }

    public String mrnaToTRNA(String rna) {
        return applyMap(mRNAToTRNAMap(), rna);
    }

    public String mRNAToDNA(String rna) {
        return applyMap(mRNAToDNAMap(), rna);
    }

    public String replaceAminos(String seq) {
        StringBuilder aminos = new StringBuilder(seq);
        Map<String, String> map = generateAminoMap();

        for(int i=0; i<aminos.length()/3; i++) {
            aminos.replace(i*3, i*3+3, map.get(aminos.substring(i*3, i*3+3)));
        }

        return aminos.toString();
    }

    private HashMap<Character, String> mRNAToTRNAMap() {
        HashMap<Character, String> map = baseDNAMRNA();

        map.put('U', "A");
        map.put('A', "U");

        return map;
    }

    private HashMap<Character, String> DNAToMRNAMap() {
        HashMap<Character, String> map = baseDNAMRNA();

        map.put('T', "A");
        map.put('A', "U");

        return map;
    }

    private HashMap<Character, String> mRNAToDNAMap() {
        HashMap<Character, String> map = baseDNAMRNA();

        map.put('A', "T");
        map.put('U', "A");

        return map;
    }

    private HashMap<Character, String> baseDNAMRNA() {
        HashMap<Character, String> map = new HashMap<>();

        map.put('C', "G");
        map.put('G', "C");
        map.put('5', "3");
        map.put('3', "5");

        return map;
    }

    private HashMap<String, String> generateAminoMap() {
        HashMap<String, String> map = new HashMap<>();

        map.put("UUU","Phe");
        map.put("UUC","Phe");
        map.put("UUA","Leu");
        map.put("UUG","Leu");
        map.put("CUU","Leu");
        map.put("CUC","Leu");
        map.put("CUA","Leu");
        map.put("CUG","Leu");
        map.put("AUU","Ile");
        map.put("AUC","Ile");
        map.put("AUA","Ile");
        map.put("AUG","Met");
        map.put("GUU","Val");
        map.put("GUC","Val");
        map.put("GUA","Val");
        map.put("GUG","Val");
        map.put("UCU","Ser");
        map.put("UCC","Ser");
        map.put("UCA","Ser");
        map.put("UCG","Ser");
        map.put("CCU","Pro");
        map.put("CCC","Pro");
        map.put("CCA","Pro");
        map.put("CCG","Pro");
        map.put("ACU","Thr");
        map.put("ACC","Thr");
        map.put("ACA","Thr");
        map.put("ACG","Thr");
        map.put("GCU","Ala");
        map.put("GCC","Ala");
        map.put("GCA","Ala");
        map.put("GCG","Ala");
        map.put("UAU","Tyr");
        map.put("UAC","Tyr");
        map.put("UAA","STOP");
        map.put("UAG","STOP");
        map.put("CAU","His");
        map.put("CAC","His");
        map.put("CAA","Gin");
        map.put("CAG","Gin");
        map.put("AAU","Asn");
        map.put("AAC","Asn");
        map.put("AAA","Lys");
        map.put("AAG","Lys");
        map.put("GAU","Asp");
        map.put("GAC","Asp");
        map.put("GAA","Glu");
        map.put("GAG","Glu");
        map.put("UGU","Cys");
        map.put("UGC","Cys");
        map.put("UGA","STOP");
        map.put("UGG","Trp");
        map.put("CGU","Arg");
        map.put("CGC","Arg");
        map.put("CGA","Arg");
        map.put("CGG","Arg");
        map.put("AGU","Ser");
        map.put("AGC","Ser");
        map.put("AGA","Arg");
        map.put("AGG","Arg");
        map.put("GGU","Gly");
        map.put("GGC","Gly");
        map.put("GGA","Gly");
        map.put("GGG","Gly");
        return map;
    }
}

