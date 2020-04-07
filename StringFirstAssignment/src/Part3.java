public class Part3 {
    public boolean twoOccurrences(String a,String b)
    {
        int first = b.indexOf(a);
        if(first==-1)
        {
            return false;
        }
        int second=b.indexOf(a,first+a.length());
        if(second==-1)
        {
            return false;
        }
       // if(a.compareTo(b.substring(second,a.length()))!=0) {
          //  return false;
      //  }
        return true;
    }
    public void testing(){
        String a= "by";
        String b="A story by Abby Long";
        System.out.println("does String "+a+" has two occurence in string "+b+" :"+twoOccurrences(a,b));
         a= "a";
         b="banana";
        System.out.println("does String"+a+" has two occurence in string "+b+" :"+twoOccurrences(a,b));
         a= "atg";
         b="ctgtatgta";
        System.out.println("does String"+a+" has two occurence in string "+b+" :"+twoOccurrences(a,b));
        a= "so";
        b="social studies";
        System.out.println("does String"+a+" has two occurence in string "+b+" :"+twoOccurrences(a,b));
         a= "an";
         b= "banana";
         System.out.println("The part of the string after "+a+" in "+b+" is "+lastPart(a,b));
        a= "Zoo";
        b= "forest";
        System.out.println("The part of the string after "+a+" in "+b+" is "+lastPart(a,b));
        a= "ma";
        b= "comma";
        System.out.println("The part of the string after "+a+" in "+b+" is "+lastPart(a,b));
    }
    public String lastPart(String a,String b)
    {
        int start= b.indexOf(a);
        if(start == -1)
        {
            return b;
        }
         else
             return b.substring(start+a.length());
    }
    public static void main(String[] args)
    {
        Part3 part= new Part3();
        part.testing();
    }
}
