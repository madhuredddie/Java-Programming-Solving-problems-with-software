public class Part2 {

    public int howMany(String a ,String b)
    {
        int startindex=0;
        int count=0;
        int currindex= 0;
        while (true)
        {
            currindex=b.indexOf(a,startindex);

            if(currindex == -1)
            {
                break;
            }
            else
            {
                count++;
                startindex=currindex+a.length();
            }
        }
        return count;
    }
    public void testHowMany()
    {
        String a="ATG";
        String b="CCATGTECATGTECATGAT";
        System.out.println("the occurence of string "+a+" in string "+b+" is "+howMany(a,b));
        a="an";
        b="banana";
        System.out.println("the occurence of string "+a+" in string "+b+" is "+howMany(a,b));
        a="GAA";
        b="ATGAACGAATTGAATC";
        System.out.println("the occurence of string "+a+" in string "+b+" is "+howMany(a,b));
        a="AA";
        b="ATAAAA";
        System.out.println("the occurence of string "+a+" in string "+b+" is "+howMany(a,b));


    }
    public  static  void main(String[] args)
    {
        Part2 part =new Part2();
        part.testHowMany();
    }


}
