import edu.duke.*;

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
    public StorageResource getAllGenes(String dna)
    {
        StorageResource sr= new StorageResource();
        int startindex=0;
        String gene="";
        while (true)
        {
            gene= findGene(dna,startindex);
            if(gene.isEmpty())
            {
                break;
            }
            else
            {
                sr.add(gene);
                startindex=dna.indexOf(gene)+gene.length();
            }
        }
        return sr;
    }
    public void testGetAllGenes()
    {
        String dna="CCATGCCTACETAGCCATGTHETEDTGATV";
        StorageResource sr= getAllGenes(dna);
        System.out.println("gene in the DNA "+dna+" are ");
        for(String s: sr.data())
        {
            System.out.println(s);
        }
        dna="CCATGCCTACETAGCCATGTCETAA";
        sr=getAllGenes(dna);
        System.out.println("gene in the DNA "+dna+" are ");
        for(String s: sr.data())
        {
            System.out.println(s);
        }

    }
    public float getCG(String dna) {
        float count = 0;
        String temp = dna.toUpperCase();
        for (int i = 0; i < temp.length(); i++) {
            if (temp.charAt(i) == 'C' || temp.charAt(i) == 'G') {
                count++;
            }
        }
        return (float) count / dna.length();
    }
    public int countCTG(String dna){
        int count=0;
        int startindex=0;
        int currentindex=0;

        while(true){
            currentindex=dna.indexOf("CTG",startindex);
            if(currentindex==-1){
                break;
            }
            count++;
            startindex=currentindex+3;
        }

        return count;
    }
    public void processGenes(StorageResource sr){
        int countlength60=0,countcg=0,maxlength=0;
        for(String s:sr.data()){
            if(s.length()>60){
                System.out.println(" String  having greater than 60characters is "+s);
                countlength60++;
            }
            if(getCG(s)>0.35){
                System.out.println("String  having C-G Ratio greater than 0.35 is "+s);
                countcg++;
            }
            if(s.length()>maxlength){
                maxlength=s.length();
            }
        }
        System.out.println("Number of strings having greater than lenght 60 :"+countlength60);
        System.out.println("number of strings having CG Ratio greater than 0.35:"+countcg);
        System.out.println("Length of the Longest String:"+maxlength);
    }
    public void testProcessGenes() {


        FileResource fr = new FileResource("brca1line.fa");
        String dna = fr.asString();
        StorageResource sr = getAllGenes(dna);
        processGenes(sr);
    }
    public static void main(String[] args)
    {
        Part1 part= new Part1();
        part.testGetAllGenes();
        part.testProcessGenes();


    }
}
