public class Part1 {
    public int findStopCodon(String dna,int startindex,String stopcodon){
       int currindex=dna.indexOf(stopcodon,startindex+3);
        while(currindex!=-1)
        {
            if((currindex-startindex)%3==0)
            {
                return currindex;
            }
            currindex=dna.indexOf(stopcodon,currindex+1);

        }
        return dna.length();
    }
    public void testFindStopCodon()
    {
        String dna="CCATGCCUTVETAATAGBU";
       int startindex = dna.indexOf("ATG");
       int stopindex=findStopCodon(dna,startindex,"TAA");
        System.out.println("stop index in DNA is "+dna+" is "+stopindex);
        dna="CCATGCCUTVETAATAGBU";
        startindex = dna.indexOf("ATG");
        stopindex=findStopCodon(dna,startindex,"TAG");
        System.out.println("stop index in DNA is "+dna+" is "+stopindex);
        dna="CCATGCCUTVETGATAGBU";
        startindex = dna.indexOf("ATG");
        stopindex=findStopCodon(dna,startindex,"TGA");
        System.out.println("stop index in DNA is "+dna+" is "+stopindex);

    }
    public String findGene(String dna,int startindex)
    {
        int index = dna.indexOf("ATG",startindex);
        if(index==-1)
        {
            return "";
        }
        int index1 = findStopCodon(dna,index,"TAA");
        int index2 = findStopCodon(dna,index,"TAG");
        int index3 = findStopCodon(dna,index,"TGA");
        int minindex=(index1>index2)? index2 : index1;
        if (minindex > index3) {
            minindex = index3;
        }
        if(minindex==dna.length())
        {
            return "";
        }
        return dna.substring(startindex,minindex+3);
    }
    public void testFindGene(){
        String dna = "CCTAGTGATAATEETAG";
        System.out.println("Gene in the given DNA  "+dna+" is "+findGene(dna,0));
        dna= "CCATGCTXTCETAACC";
        System.out.println("Gene in the given DNA  "+dna+" is "+findGene(dna,0));
        dna= "CCATGCTXTCETAATAGCC";
        System.out.println("Gene in the given DNA  "+dna+" is  "+findGene(dna,0));
        dna= "CCATGCTXTTAATGACC";
        System.out.println("Gene in the given DNA  "+dna+" is "+findGene(dna,0));
        dna= "CCATGCTXTCETHETACCC";
        System.out.println("Gene in the given DNA  "+dna+" is "+findGene(dna,0));

    }
    public void printAllGenes(String dna)
    {
        int startindex=0;
        String gene="";
        while (true)
        {
             gene= findGene(dna,startindex);
            if(gene.length()==0)
            {
                break;
            }
            else
            {
                System.out.println(gene);
                startindex=dna.indexOf(gene)+gene.length();
            }
        }
    }
    public void testPrintAllGenes()
    {
        String dna="CCATGCCTACETAGCCATGTHETEDTGATV";
       System.out.println("Genes in the DNA  "+dna);
       printAllGenes(dna);
        dna="CCATGCCTACETAGCCATGTCETAA";
        System.out.println("Genes in the DNA  "+dna);
        printAllGenes(dna);
    }
    public static  void main(String[] args){
        Part1 part= new Part1();
        part.testFindGene();
        part.testFindStopCodon();
        part.testPrintAllGenes();
    }
}
