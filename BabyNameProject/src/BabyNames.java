import edu.duke.*;
import org.apache.commons.csv.*;
import java.io.File;
public class BabyNames {
    void totalBirths(){
        int numOfGirls=0,numOfBoys=0,totalNames=0;
        System.out.println("Select the file in the downloads to caluclate  total birth");
        FileResource fr=new FileResource();
        CSVParser parser=fr.getCSVParser(false);
        for(CSVRecord record:parser){

            if(record.get(1).equals("F")){
                numOfGirls++;
            }
            else
                numOfBoys++;

            totalNames++;


        }
        System.out.println("Total Number Of Names is "+totalNames);
        System.out.println("Total number Of Girl Names is "+numOfGirls);
        System.out.println("Toatl Number Of Boy Names is "+numOfBoys);


    }
    /**
     *Write the method named getRank that has three parameters: an integer named year, a string named name, and a string named gender (F for female and M for male).
     * This method returns the rank of the name in the file for the given gender, where rank 1 is the name with the largest number of births.
     * If the name is not in the file, then -1 is returned.
     * For example, in the file "yob2012short.csv", given the name Mason, the year 2012 and the gender ‘M’,
     * the number returned is 2, as Mason is the boys name with the second highest number of births.
     *
     * @param year
     * @param name
     * @param gender
     * @return rank
     */

    int getRank(int year,String name,String gender){
        int rank=0;
        System.out.println("Select the File yob"+year+"short.csv in the downloads to know rank of"+name);
        FileResource fr=new FileResource();
        CSVParser parser=fr.getCSVParser(false);
        for(CSVRecord record:parser){

            if(record.get(1).equals(gender)){
                rank++;
            }
            if(record.get(0).equals(name)&&record.get(1).equals(gender)){
                return rank;
            }
        }
        return -1;
    }
    /**
     * Write the method named getName that has three parameters: an integer named year, an integer named rank, and a string named gender (F for female and M for male).
     * This method returns the name of the person in the file at this rank, for the given gender,
     * where rank 1 is the name with the largest number of births.
     * If the rank does not exist in the file, then “NO NAME” is returned.
     *
     * @param year
     * @param rank
     * @param gender
     * @return name
     */
    String getName(int year,int rank,String gender){
        int rankInFile=0;
       System.out.println("Select the particular File yob"+year+"short.csv in the downloads to know the name of given rank"+rank+" in year"+year+" of gender "+gender);
        FileResource fr=new FileResource();
        CSVParser parser=fr.getCSVParser(false);
        for(CSVRecord record:parser){
            if(record.get(1).equals(gender)){
                rankInFile++;
            }
            if(rankInFile==rank&&record.get(1).equals(gender)){
                return record.get(0);
            }
        }
        return "No Name";
    }
    /**
     *
     * To find the rank of given name and gender using CSVParser
     * @param parser
     * @param name
     * @param gender
     * @return  name
     */
    int getRankInFile(CSVParser parser,String name,String gender){
        int rank=0;
        for(CSVRecord record:parser){

            if(record.get(1).equals(gender)){
                rank++;
            }
            if(record.get(0).equals(name)&&record.get(1).equals(gender)){

                return rank;
            }
        }
        return -1;



    }
    /**
     * What would your name be if you were born in a different year? Write the void method named whatIsNameInYear that has four parameters:
     * a string name, an integer named year representing the year that name was born, an integer named newYear and a string named gender
     * This method determines what name would have been named if they were born in a different year,
     * based on the same popularity. That is, you should determine the rank of name in the year they were born,
     * and then print the name born in newYear that is at the same rank and same gender.
     * For example, using the files "yob2012short.csv" and "yob2014short.csv", notice that in 2012 Isabella is the third most popular girl's name. If Isabella was born in 2014 instead,
     * she would have been named Sophia, the third most popular girl's name that year.
     * @param name
     * @param year
     * @param gender
     * @param newYear
     */

    void whatIsNameInYear(String name,int year,String gender,int newYear)
    {

       System.out.println("Select the particular File yob"+year+"short.csv in your downloads ");

        int rankOfGivenName=0;
        FileResource fr1=new FileResource();
        for(CSVRecord record:fr1.getCSVParser(false)){
            if(record.get(1).equals(gender)) {
                rankOfGivenName++;
            }
            if(record.get(0).equals(name)&&record.get(1).equals(gender)){
                break;
            }

        }
        System.out.println("Now,Select the File yob"+newYear+"short.csv");


        int rankInFile=0;
        FileResource fr2=new FileResource();
        CSVRecord nameRecord=null;

        for(CSVRecord record:fr2.getCSVParser(false)) {
            if (record.get(1).equals(gender)) {

                rankInFile++;
                if (rankInFile == rankOfGivenName) {
                    nameRecord=record;
                    break;
                }
            }
        }

        System.out.println(" The name of"+name+" who was born in "+year+" would be "+nameRecord.get(0)+" if the  baby was born in "+newYear);



    }
    /**
     * Write the method getAverageRank that has two parameters: a string name, and a string named gender (F for female and M for male).
     * This method selects a range of files to process and returns a double representing the average rank of the name and gende over the selected files.
     * It should return -1.0 if the name is not ranked in any of the selected files.
     * @param name
     * @param gender
     * @return
     */



    double getAverageRank(String name,String gender){

        int currentRank=0,totalrank=0,TotalFiles=0;

        DirectoryResource dr = new DirectoryResource();

        for (File f : dr.selectedFiles()) {

            FileResource fr = new FileResource(f);
            CSVParser parser = fr.getCSVParser(false);


            currentRank=getRankInFile(parser,name,gender);
            if(currentRank==-1){
                return -1.0;
            }
            totalrank +=currentRank;
            TotalFiles++;
        }

        return (double)totalrank/TotalFiles;

    }
    /**
     * Write the method yearOfHighestRank that has two parameters: a string name, and a string named gender.
     * This method selects a range of files to process and returns an integer, the year with the highest rank
     * for the name and gender. If the name and gender are not in any of the selected files, it should return -1.
     * For example, calling yearOfHighestRank with name Mason and gender ‘M’ and selecting the three test files above results in returning the year 2012.
     * That is because Mason was ranked the 2nd most popular name in 2012, ranked 4th in 2013 and ranked 3rd in 2014.
     * His highest ranking was in 2012.
     *
     *
     * @param name
     * @param gender
     * @return year of highest rank
     */


    int yearOfHighestRank(String name,String gender) {


        int currentRank = 0, highestRank =0;
        String fileNameHavingHighestRank = "";
        DirectoryResource dr = new DirectoryResource();

        for (File f : dr.selectedFiles()) {

            FileResource fr = new FileResource(f);
            CSVParser parser = fr.getCSVParser(false);

            currentRank = getRankInFile(parser, name, gender);
            if (currentRank > highestRank) {
                highestRank = currentRank;
                fileNameHavingHighestRank = f.getName();
            }
        }
        String yearHavingHighestRank = fileNameHavingHighestRank.substring(3,7);
        return Integer.parseInt(yearHavingHighestRank);


    }

    /**
     * Write the method getTotalBirthsRankedHigher that has three parameters: an integer named year, a string named name, and a string named gender (
     *  This method returns an integer, the total number of births of those names with the same gender and same year who are ranked higher than name.
     *  For example, if getTotalBirthsRankedHigher accesses the "yob2012short.csv" file with name set to “Ethan”, gender set to “M”, and year set to 2012,
     *  then this method should return 15, since Jacob has 8 births and Mason has 7 births, and those are the only two ranked higher than Ethan.
     *
     * @param year
     * @param name
     * @param gender
     * @return Total births RankedHigher Than Particular
     */

    int getTotalBirthsRankedHigher(int year,String name,String gender){

        System.out.println("Select the particular  File yob"+year+"short.csv in the downloads");
        FileResource fr=new FileResource();
        CSVParser parser=fr.getCSVParser(false);

        int rankOfGivenName = getRankInFile(parser,name,gender);

        parser=fr.getCSVParser(false);
        int TotalBirths=0,currentRank=0;

        for(CSVRecord record:parser){
            if(record.get(1).equals(gender)){
                currentRank++;
                if(currentRank<rankOfGivenName){
                    TotalBirths=TotalBirths+Integer.parseInt(record.get(2));
                }
            }
        }
        return TotalBirths;
    }

    /**
     * these method tests the get rank method
     */
    public void testGetRank()
    {
        int rank=getRank(2012,"Emma","F");
        if(rank!=-1)
            System.out.println("Rank of Name Emma with the Gender F in the Year 2012 is "+rank);
        else
            System.out.println("No baby with name Emma with the Gender F in the Year 2012");
    }

    /**
     * this method test the getname method which doesnot take any parameter
     */
    public void testGetname(){
        int year=2014;
        int rank= 4;
        String gender="M";
        String name = getName(year,rank,gender);
        if (!name.equals("No Name"))
            System.out.println("Name of baby with the Gender "+gender+"  in the Year "+year+"   having the rank "+rank+" is " + name);
        else
            System.out.println(name);
    }
    /**
     * this method test the WhatIsNewName method which doesnot take any parameter
     */
    public void testWhatIsNewName(){
        String name="Helen";
        String gender="F";
        int year=1910;
        int newyear=2014;
        whatIsNameInYear(name,year,gender,newyear);
    }
    /**
     * this method test the yearOfHighestRank method which doesnot take any parameter
     */
    public  void testYearOfHighestRank(){
        String name="Emma";
        String gender="F";
        System.out.println("Year having Highest Rank of "+name+"  of Gender "+gender+"is "+yearOfHighestRank(name,gender));
    }
    /**
     * this method test the getAverageRank method which doesnot take any parameter
     */
    public void testGetAverageRank()
    {
        String name="Emma";
        String gender="F";
        System.out.println("Average Rank of "+name+"  of Gender "+gender+"is "+getAverageRank(name,gender));
    }
    /**
     * this method test the gettotalBirthRankedHigher method which doesnot take any parameter
     */
    public void testGetTotalBrithRankedHigher()
    {
        String name="Helen";
        String gender="F";
        int year=1910;
        System.out.println("Sum Of Births Ranked Higher than name "+name+" of gender "+gender+" is "+getTotalBirthsRankedHigher(year,name,gender));
    }
    public void tester()
    {
       totalBirths();
       testGetRank();
       testGetname();
       testWhatIsNewName();
       testYearOfHighestRank();
       testGetAverageRank();
       testGetTotalBrithRankedHigher();
    }

    public static void main(String args[]) {

        BabyNames part = new BabyNames();
        part.tester();


    }

}


