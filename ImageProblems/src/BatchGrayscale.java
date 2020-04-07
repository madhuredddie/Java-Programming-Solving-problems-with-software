import edu.duke.*;
import java.io.File;
public class BatchGrayscale {
    /**
     *
     *  This method Convert images to GrayScale images
     * @param inImage
     * @return an image
     */

    public ImageResource makeGrayImage(ImageResource inImage){


        ImageResource outImage=new ImageResource(inImage.getWidth(),inImage.getHeight());

        for(Pixel pixel:outImage.pixels()){

            Pixel inPixel=inImage.getPixel(pixel.getX(),pixel.getY());

            int average=(inPixel.getRed()+inPixel.getBlue()+inPixel.getGreen())/3;

            pixel.setBlue(average);
            pixel.setRed(average);
            pixel.setGreen(average);

        }
        return outImage;

    }

    /**
     *  This method Selects Multiple Images and converting to GrayScale and saving them with
     * a new file name with prefix as gray- and same filename
     *
     */


    public void changingMultipcleImages() {
        DirectoryResource dr = new DirectoryResource();

        for (File f : dr.selectedFiles()) {

            ImageResource image = new ImageResource(f);
            ImageResource grayImage = makeGrayImage(image);
            String filename = image.getFileName();
            String newName = "gray-" + filename;

            grayImage.setFileName(newName);

            grayImage.save();

        }
    }

    public static void main(String args[])
    {

        BatchGrayscale part=new BatchGrayscale();
        part.changingMultipcleImages();
    }


}
