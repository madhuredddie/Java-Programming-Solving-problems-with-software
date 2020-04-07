public class Part3 {
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
    public int countGene(String dna)
    {
        int startindex=0;
        String gene="";
        int count=0;
        while (true)
        {
            gene= findGene(dna,startindex);
            if(gene.isEmpty())
            {
                break;
            }
            else
            {
                count++;
                startindex=dna.indexOf(gene)+gene.length();
            }
        }
        return count;
    }
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

    public void testCountGene()
    {
        String dna ="CCATGCCTACETAGCCATGTHETEDTGATV";
         System.out.println("the number of gene in DNA is "+dna+" is "+countGene(dna));
        dna ="CCATGCCTACETAGCCATGTCETAA";
        System.out.println("the number of gene in DNA is "+dna+" is "+countGene(dna));
        dna ="CCATGCCTACETAUCCATGTCETAF";
        System.out.println("the number of gene in DNA is "+dna+" is "+countGene(dna));
    }
    public static void main(String[] args)
    {
        Part3 part=new Part3();
        part.testCountGene();

    }
}
