package week1;

import javax.swing.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class LukesProgram {

    public static void main(String[] args) {
        new DNAInfo();
    }

    public String dnaToMRNA(String dna) {
        String rna = dna;

        rna = rna.replace("A", "U");
        rna = rna.replace("T", "A");

        for(int i=0; i<rna.length(); i++) {
            if(rna.charAt(i) == 'C') {
                rna = rna.substring(0, i) + 'G' + rna.substring(i + 1, rna.length());
            } else if(rna.charAt(i) == 'G') {
                rna = rna.substring(0, i) + 'C' + rna.substring(i + 1, rna.length());
            } else if(rna.charAt(i) == '5') {
                rna = rna.substring(0, i) + '3' + rna.substring(i + 1, rna.length());
            } else if(rna.charAt(i) == '3') {
                rna = rna.substring(0, i) + '5' + rna.substring(i + 1, rna.length());
            }
        }

        return rna;
    }

    public String mrnaToTRNA(String dna) {
        String rna = dna;

        for(int i=0; i<rna.length(); i++) {
            if(rna.charAt(i) == 'C') {
                rna = rna.substring(0, i) + 'G' + rna.substring(i + 1, rna.length());
            } else if(rna.charAt(i) == 'G') {
                rna = rna.substring(0, i) + 'C' + rna.substring(i + 1, rna.length());
            } else if(rna.charAt(i) == '5') {
                rna = rna.substring(0, i) + '3' + rna.substring(i + 1, rna.length());
            } else if(rna.charAt(i) == '3') {
                rna = rna.substring(0, i) + '5' + rna.substring(i + 1, rna.length());
            }  else if(rna.charAt(i) == 'U') {
                rna = rna.substring(0, i) + 'A' + rna.substring(i + 1, rna.length());
            }  else if(rna.charAt(i) == 'A') {
                rna = rna.substring(0, i) + 'U' + rna.substring(i + 1, rna.length());
            }
        }

        return rna;
    }

    public String mRNAToDNA(String dna) {
        String rna = dna;

        rna = rna.replace("A", "T");
        rna = rna.replace("U", "A");

        for(int i=0; i<rna.length(); i++) {
            if(rna.charAt(i) == 'C') {
                rna = rna.substring(0, i) + 'G' + rna.substring(i + 1, rna.length());
            } else if(rna.charAt(i) == 'G') {
                rna = rna.substring(0, i) + 'C' + rna.substring(i + 1, rna.length());
            } else if(rna.charAt(i) == '5') {
                rna = rna.substring(0, i) + '3' + rna.substring(i + 1, rna.length());
            } else if(rna.charAt(i) == '3') {
                rna = rna.substring(0, i) + '5' + rna.substring(i + 1, rna.length());
            }
        }

        return rna;
    }

    public String replaceAminos(String seq) {
        /*String aminos = seq;
        Map<String, String> map = generateAminoMap();

        if(seq.length()%3 != 0)
            return "Sequence is not a multiple of 3";

        for(int i=0; i<aminos.length()/3+1; i++) {
            int seqStart = i*3-1;
            int seqEnd = seqStart+4;
            System.out.println(aminos.substring(i == 0 ? 0 : seqStart, seqEnd) + " " + seqStart + seqEnd);
            String replaceWith = map.get(i == 0 ? 0 : aminos.substring(seqStart, seqEnd));

            if(seqEnd < aminos.length())    aminos = aminos.substring(0, seqStart+1) + replaceWith + aminos.substring(seqEnd + 1);
            else aminos = aminos.substring(0, seqStart) + replaceWith;
        }

        return aminos;*/

        StringBuilder aminos = new StringBuilder(seq);
        Map<String, String> map = generateAminoMap();

        for(int i=0; i<aminos.length()/3; i++) {
            aminos.replace(i*3, i*3+3, map.get(aminos.substring(i*3, i*3+3)));
        }

        return aminos.toString();
    }

    public HashMap<String, String> generateAminoMap() {
        HashMap<String, String> map = new HashMap<String, String>();

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
        map.put("ACU","Ser");
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

