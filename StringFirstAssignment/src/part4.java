import edu.duke.URLResource;

public class part4 {
    public void getUrl(){
        URLResource url = new URLResource("http://www.dukelearntoprogram.com/course2/data/manylinks.html");
        String result=null;
        String linelower=null;
        for(String line : url.lines())
        {
            linelower = line.toLowerCase();
            int index = linelower.indexOf("youtube.com");
            if(index!=-1)
            {
                int startindex= linelower.indexOf("\"",linelower.indexOf("href"));
                int endindex = linelower.indexOf(">",startindex);
                result=line.substring(startindex,endindex);
                System.out.println(result);
            }

        }
    }
    public static void main(String[] args)
    {
        part4 part= new part4();
        part.getUrl();
    }
}
