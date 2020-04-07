public class Part2 {
    public String findSimpleGene(String startcode,String dna,String stopcode)
    {    String resultString=null;
        char start= dna.charAt(0);
        if(Character.isLowerCase(start))
        {
            resultString=dna.toLowerCase();
        }
        else
        {
            resultString=dna.toUpperCase();
        }
        int startindex=resultString.indexOf(startcode);
        int stopindex=resultString.indexOf(stopcode,startindex+3);
        String gene= null;
        if(startindex==-1)
        {
            return "";
        }
        if(stopindex==-1)
        {
            return "";
        }
        gene = resultString.substring(startindex,stopindex+3);
        if(gene.length()%3==0){
            return gene;
        }
        return "";
    }
    public void testSimpleGene()
    {
        String dna1 = "CCATGEFHUFYJKU";
        System.out.println("DNA :"+dna1);
        System.out.println("gene is :"+findSimpleGene("ATG",dna1,"TAA"));
        String dna2 = "CCETFUHTIHTAAYU";
        System.out.println("DNA :"+dna2);
        System.out.println("gene is :"+findSimpleGene("ATG",dna2,"TAA"));
        String dna3 =  "CCYEHYGHTERFIU";
        System.out.println("DNA :"+dna3);
        System.out.println("gene is :"+findSimpleGene("ATG",dna3,"TAA"));
        String dna4 = "CCATGHEFMADUGHTAAIJK";
        System.out.println("DNA :"+dna4);
        System.out.println("gene is :"+findSimpleGene("ATG",dna4,"TAA"));
        String dna5 = "CCATGHEFGHUYJTAA";
        System.out.println("DNA :"+dna5);
        System.out.println("gene is :"+findSimpleGene("ATG",dna3,"TAA"));

        return ;
    }
    public static void main(String[] args)
    {
        Part2 part= new Part2();
        part.testSimpleGene();
        return ;
    }

}
