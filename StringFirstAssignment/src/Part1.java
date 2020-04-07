public class Part1 {
    public String findSimpleGene(String dna)
    {
        int startindex=dna.indexOf("ATG");
        int stopindex=dna.indexOf("TAA",startindex+3);
        String gene= null;
        if(startindex==-1)
        {
            return "";
        }
        if(stopindex==-1)
        {
            return "";
        }
        gene = dna.substring(startindex,stopindex+3);
        if(gene.length()%3==0){
            return gene;
        }
        return "";
    }
    public void testSimpleGene()
    {
        String dna1 = "CCATGEFHUFYJKU";
        System.out.println("DNA :"+dna1);
        System.out.println("gene is :"+findSimpleGene(dna1));
        String dna2 = "CCETFUHTIHTAAYU";
        System.out.println("DNA :"+dna2);
        System.out.println("gene is :"+findSimpleGene(dna2));
        String dna3 =  "CCYEHYGHTERFIU";
        System.out.println("DNA :"+dna3);
        System.out.println("gene is :"+findSimpleGene(dna3));
        String dna4 = "CCATGHEFMADUGHTAAIJK";
        System.out.println("DNA :"+dna4);
        System.out.println("gene is :"+findSimpleGene(dna4));
        String dna5 = "CCATGHEFGHUYJTAA";
        System.out.println("DNA :"+dna5);
        System.out.println("gene is :"+findSimpleGene(dna5));
        return ;
    }
    public static void main(String[] args)
    {
        Part1 part= new Part1();
        part.testSimpleGene();
        return ;
    }


}
