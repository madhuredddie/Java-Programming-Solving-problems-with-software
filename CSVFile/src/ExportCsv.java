import edu.duke.*;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

//questions are commented above each method
public class ExportCsv {

    String countryInfo(CSVParser parser,String country){

        for(CSVRecord record:parser){

            if(record.get("Country").equals(country)){
                return record.get("Country")+": " +record.get("Exports")+": "+record.get("Value (dollars)");
            }

        }
        return "NOT FOUND";

    }
    void listExportsTwoProducts(CSVParser parser,String expoertItem1,String exportItem2)
    {

        System.out.println("The Countries containing the exports "+expoertItem1+","+exportItem2+" are");
        for(CSVRecord record:parser)
        {

            String export=record.get("Exports");

            if(export.contains(expoertItem1)&&export.contains(exportItem2))
            {
                System.out.println(record.get("Country"));
            }

        }
    }
    int numberOfExporters(CSVParser parser,String exportItem){
        int count=0;
        String export="";
        for(CSVRecord record:parser)
             export = record.get("Exports");
            if(export.contains(exportItem)){
                count++;
            }
        return count;
    }
    void bigExporters(CSVParser parser,String amount){

        System.out.println("Big Exporters are");
        for(CSVRecord record:parser){

            String value=record.get("Value (dollars)");
            if(amount.length()<value.length()){
                System.out.println(record.get("Country")+" "+record.get("Value (dollars)"));
            }
        }
    }
    void tester()
    {
        FileResource fr=new FileResource();
        CSVParser parser=fr.getCSVParser();

        listExportsTwoProducts(parser,"gold","diamonds");

        parser=fr.getCSVParser();
        String coinfo=countryInfo(parser,"Germany");
        System.out.println("Country's Export Info "+coinfo);
        coinfo=countryInfo(parser,"Peru");
        System.out.println("Country's Export info "+coinfo);
        parser=fr.getCSVParser();
        int countOfExporters=numberOfExporters(parser,"gold");
        System.out.println("Number of Countries exporting gold:"+countOfExporters);

        parser=fr.getCSVParser();

        bigExporters(parser,"$999,999,999,999");

    }

    public static void main(String args[]){
        ExportCsv export=new ExportCsv();
        export.tester();
    }
}
