/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hilbert;

import java.util.ArrayList;

/**
 *
 * @author Georgios
 */
public class Pixel {

    private int position_range_start = -1;
    private int zoom_level = 1;
    private int position_range_end = -1;
    private ColorHilbert color_hilbert_ref;
    private ColorHilbert color_hilbert_sample1;
    private ColorHilbert color_hilbert_ratio1;
    private ColorHilbert color_hilbert_sample2;
    private ColorHilbert color_hilbert_ratio2;
    private ColorHilbert color_hilbert_sample3;
    private ColorHilbert color_hilbert_ratio3;
    private ColorHilbert color_hilbert_sample4;
    private ColorHilbert color_hilbert_ratio4;
    private ColorHilbert color_duplication;
    private ColorHilbert color_deletion;
    private ColorHilbert color_pair_end;
    private ColorHilbert color_inversion;
    private ColorHilbert color_insertion;
    private ColorHilbert color_translocation;
    private double coverage_reference1 = 0;
    private double coverage_sample1 = 0;
    private double ratio1 = 0;
    private double coverage_reference2 = 0;
    private double coverage_sample2 = 0;
    private double ratio2 = 0;
    private double coverage_reference3 = 0;
    private double coverage_sample3 = 0;
    private double ratio3 = 0;
    private double coverage_reference4 = 0;
    private double coverage_sample4 = 0;
    private double ratio4 = 0;
    private Coordinate coordinate_hilbert;
    private boolean deletion = false;
    private boolean inversion = false;
    private boolean duplication = false;
    private boolean insertion = false;
    private boolean translocation = false;
    public ArrayList<Pixel> pair_ends = new ArrayList();
    public ArrayList<String> pair_end_variation_type = new ArrayList();
    public ArrayList<String> pair_end_destination_chromosome = new ArrayList();
    public ArrayList<Integer> pair_end_destination_chromosome_position = new ArrayList();
    public ArrayList<String> pair_end_source_chromosome = new ArrayList();
    public ArrayList<Integer> sample = new ArrayList();

    public Pixel() {
        position_range_start = -1;
        color_hilbert_ref = new ColorHilbert(255, 255, 255, 0);
        color_pair_end = new ColorHilbert(255, 0, 0, 0);
        color_hilbert_sample1 = new ColorHilbert(255, 255, 255, 0);
        color_hilbert_ratio1 = new ColorHilbert(255, 255, 255, 0);
        color_hilbert_sample2 = new ColorHilbert(255, 255, 255, 0);
        color_hilbert_ratio2 = new ColorHilbert(255, 255, 255, 0);
        color_hilbert_sample3 = new ColorHilbert(255, 255, 255, 0);
        color_hilbert_ratio3 = new ColorHilbert(255, 255, 255, 0);
        color_hilbert_sample4 = new ColorHilbert(255, 255, 255, 0);
        color_hilbert_ratio4 = new ColorHilbert(255, 255, 255, 0);
        color_duplication = new ColorHilbert(255, 255, 255, 0);
        color_deletion = new ColorHilbert(255, 255, 255, 0);
        color_inversion = new ColorHilbert(255, 255, 255, 0);
        color_insertion = new ColorHilbert(255, 255, 255, 0);
        color_translocation = new ColorHilbert(255, 255, 255, 0);
        coverage_reference1 = 0;
        coverage_sample1 = 0;
        coverage_reference2 = 0;
        coverage_sample2 = 0;
        coverage_reference3 = 0;
        coverage_sample3 = 0;
        coverage_reference4 = 0;
        coverage_sample4 = 0;
        coordinate_hilbert = new Coordinate(-1, -1);
    }

    public String toString() {
        return "position:" + getPosition_range_start() + "-" + getPosition_range_end()
                + "\treference:" + getCoverage_reference()
                + "\tsample1:" + getCoverage_sample1()
                + "\tratio1:" + getRatio1()
                + "\tsample2:" + getCoverage_sample2()
                + "\tratio2:" + getRatio2()
                + "\tsample3:" + getCoverage_sample3()            
                + "\tratio3:" + getRatio3()
                + "\tsample4:" + getCoverage_sample4()
                + "\tratio4:" + getRatio4()
                + "\tcoord:" + getCoordinate_hilbert().toString()
                + "\tdeletion:" + isDeletion()
                + "\tinsertion:" + isInsertion()
                + "\ttranslocation:" + isTranslocation()
                + "\tinversion:" + isInversion()
                + "\tduplication:" + isDuplication();


    }

    /**
     * @return the position
     */
    public int getPosition_range_start() {
        return position_range_start;
    }

    public int getPosition_range_middle() {
        return (int) (((float) position_range_start + (float) position_range_start) / (float) 2);
    }

    /**
     * @param position the position to set
     */
    public void setPosition_range_start(int position) {
        this.position_range_start = position;
    }

    /**
     * @return the color_hilbert
     */
    public ColorHilbert getColor_hilbert_ref() {
        return color_hilbert_ref;
    }

    /**
     * @param color_hilbert the color_hilbert to set
     */
    public void setColor_hilbert_ref(ColorHilbert color) {
        this.color_hilbert_ref.R = color.R;
        this.color_hilbert_ref.G = color.G;
        this.color_hilbert_ref.B = color.B;
        this.color_hilbert_ref.alpha = color.alpha;


    }

    public ColorHilbert getColor_hilbert_sample1() {
        return color_hilbert_sample1;
    }

    public ColorHilbert getColor_hilbert_sample2() {
        return color_hilbert_sample2;
    }

    public ColorHilbert getColor_hilbert_sample3() {
        return color_hilbert_sample3;
    }

    public ColorHilbert getColor_hilbert_sample4() {
        return color_hilbert_sample4;
    }

    /**
     * @param color_hilbert the color_hilbert to set
     */
    public void setColor_hilbert_sample1(ColorHilbert color) {
        this.color_hilbert_sample1.R = color.R;
        this.color_hilbert_sample1.G = color.G;
        this.color_hilbert_sample1.B = color.B;
        this.color_hilbert_sample1.alpha = color.alpha;
    }

    public void setColor_hilbert_sample2(ColorHilbert color) {
        this.color_hilbert_sample2.R = color.R;
        this.color_hilbert_sample2.G = color.G;
        this.color_hilbert_sample2.B = color.B;
        this.color_hilbert_sample2.alpha = color.alpha;
    }

    public void setColor_hilbert_sample3(ColorHilbert color) {
        this.color_hilbert_sample3.R = color.R;
        this.color_hilbert_sample3.G = color.G;
        this.color_hilbert_sample3.B = color.B;
        this.color_hilbert_sample3.alpha = color.alpha;
    }

    public void setColor_hilbert_sample4(ColorHilbert color) {
        this.color_hilbert_sample4.R = color.R;
        this.color_hilbert_sample4.G = color.G;
        this.color_hilbert_sample4.B = color.B;
        this.color_hilbert_sample4.alpha = color.alpha;
    }

    public ColorHilbert getColor_hilbert_ratio1() {
        return color_hilbert_ratio1;
    }

    public ColorHilbert getColor_hilbert_ratio2() {
        return color_hilbert_ratio2;
    }

    public ColorHilbert getColor_hilbert_ratio3() {
        return color_hilbert_ratio3;
    }

    public ColorHilbert getColor_hilbert_ratio4() {
        return color_hilbert_ratio4;
    }

    /**
     * @param color_hilbert the color_hilbert to set
     */
    public void setColor_hilbert_ratio1(ColorHilbert color) {
        this.color_hilbert_ratio1.R = color.R;
        this.color_hilbert_ratio1.G = color.G;
        this.color_hilbert_ratio1.B = color.B;
        this.color_hilbert_ratio1.alpha = color.alpha;

    }

    public void setColor_hilbert_ratio2(ColorHilbert color) {
        this.color_hilbert_ratio2.R = color.R;
        this.color_hilbert_ratio2.G = color.G;
        this.color_hilbert_ratio2.B = color.B;
        this.color_hilbert_ratio2.alpha = color.alpha;

    }

    public void setColor_hilbert_ratio3(ColorHilbert color) {
        this.color_hilbert_ratio3.R = color.R;
        this.color_hilbert_ratio3.G = color.G;
        this.color_hilbert_ratio3.B = color.B;
        this.color_hilbert_ratio3.alpha = color.alpha;

    }

    public void setColor_hilbert_ratio4(ColorHilbert color) {
        this.color_hilbert_ratio4.R = color.R;
        this.color_hilbert_ratio4.G = color.G;
        this.color_hilbert_ratio4.B = color.B;
        this.color_hilbert_ratio4.alpha = color.alpha;

    }

    public ColorHilbert getColor_duplication() {
        return color_duplication;
    }

    public ColorHilbert getColor_deletion() {
        return color_deletion;
    }

    public ColorHilbert getColor_inversion() {
        return color_inversion;
    }

    public ColorHilbert getColor_insertion() {
        return color_insertion;
    }

    public ColorHilbert getColor_translocation() {
        return color_translocation;
    }

    public ColorHilbert getColor_pair_end() {
        return color_pair_end;
    }

    /**
     * @param color_hilbert the color_hilbert to set
     */
    public void setColor_duplication(ColorHilbert color) {
        this.color_duplication.R = color.R;
        this.color_duplication.G = color.G;
        this.color_duplication.B = color.B;
        this.color_duplication.alpha = color.alpha;
    }

    public void setColor_pair_end(ColorHilbert color) {
        this.color_pair_end.R = color.R;
        this.color_pair_end.G = color.G;
        this.color_pair_end.B = color.B;
        this.color_pair_end.alpha = color.alpha;
    }

    public void setColor_deletion(ColorHilbert color) {
        this.color_deletion.R = color.R;
        this.color_deletion.G = color.G;
        this.color_deletion.B = color.B;
        this.color_deletion.alpha = color.alpha;
    }

    public void setColor_inversion(ColorHilbert color) {
        this.color_inversion.R = color.R;
        this.color_inversion.G = color.G;
        this.color_inversion.B = color.B;
        this.color_inversion.alpha = color.alpha;
    }

    public void setColor_insertion(ColorHilbert color) {
        this.color_insertion.R = color.R;
        this.color_insertion.G = color.G;
        this.color_insertion.B = color.B;
        this.color_insertion.alpha = color.alpha;
    }

    public void setColor_translocation(ColorHilbert color) {
        this.color_translocation.R = color.R;
        this.color_translocation.G = color.G;
        this.color_translocation.B = color.B;
        this.color_translocation.alpha = color.alpha;
    }

    /**
     * @return the coverage_reference
     */
   
       public double getCoverage_reference() {
        return coverage_reference4;
    }

    /**
     * @param coverage_reference the coverage_reference to set
     */
   
      
       public void setCoverage_reference(double coverage_reference) {
        this.coverage_reference4 = coverage_reference;
    }

    /**
     * @return the coverage_sample
     */
    public double getCoverage_sample1() {
        return coverage_sample1;
    }
    
    public double getCoverage_sample2() {
        return coverage_sample2;
    }
    
    public double getCoverage_sample3() {
        return coverage_sample3;
    }
    
    public double getCoverage_sample4() {
        return coverage_sample4;
    }

    /**
     * @param coverage_sample the coverage_sample to set
     */
    public void setCoverage_sample1(double coverage_sample) {
        this.coverage_sample1 = coverage_sample;
    }
    public void setCoverage_sample2(double coverage_sample) {
        this.coverage_sample2 = coverage_sample;
    }
    public void setCoverage_sample3(double coverage_sample) {
        this.coverage_sample3 = coverage_sample;
    }
    public void setCoverage_sample4(double coverage_sample) {
        this.coverage_sample4 = coverage_sample;
    }

    /**
     * @return the coordinate_hilbert
     */
    public Coordinate getCoordinate_hilbert() {
        return coordinate_hilbert;
    }

    /**
     * @param coordinate_hilbert the coordinate_hilbert to set
     */
    public void setCoordinate_hilbert(Coordinate coordinate_hilbert) {
        this.coordinate_hilbert = coordinate_hilbert;
    }

    public String getRatio_String1() {
        return GenericMethods.get_shorter_double(this.ratio1);
    }
    public String getRatio_String2() {
        return GenericMethods.get_shorter_double(this.ratio2);
    }
    public String getRatio_String3() {
        return GenericMethods.get_shorter_double(this.ratio3);
    }
    public String getRatio_String4() {
        return GenericMethods.get_shorter_double(this.ratio4);
    }

    public void setRatio1(double r) {
        this.ratio1 = r;
    }
    public void setRatio2(double r) {
        this.ratio2 = r;
    }
    public void setRatio3(double r) {
        this.ratio3 = r;
    }
    public void setRatio4(double r) {
        this.ratio4 = r;
    }

    public double getRatio1() {
        return this.ratio1;
    }
    public double getRatio2() {
        return this.ratio2;
    }
    public double getRatio3() {
        return this.ratio3;
    }
    public double getRatio4() {
        return this.ratio4;
    }

    /**
     * @return the position_range_end
     */
    public int getPosition_range_end() {
        return position_range_end;
    }

    /**
     * @param position_range_end the position_range_end to set
     */
    public void setPosition_range_end(int position_range_end) {
        this.position_range_end = position_range_end;
    }

    /**
     * @return the deletion
     */
    public boolean isDeletion() {
        return deletion;
    }

    /**
     * @param deletion the deletion to set
     */
    public void setDeletion(boolean deletion) {
        this.deletion = deletion;
    }

    /**
     * @return the inversion
     */
    public boolean isInversion() {
        return inversion;
    }

    /**
     * @param inversion the inversion to set
     */
    public void setInversion(boolean inversion) {
        this.inversion = inversion;
    }

    /**
     * @return the duplication
     */
    public boolean isDuplication() {
        return duplication;
    }

    /**
     * @param duplication the duplication to set
     */
    public void setDuplication(boolean duplication) {
        this.duplication = duplication;
    }

    public boolean isInsertion() {
        return duplication;
    }

    public void setInsertion(boolean insertion) {
        this.insertion = insertion;
    }

    public boolean isTranslocation() {
        return translocation;
    }

    public void setTranslocation(boolean translocation) {
        this.translocation = translocation;
    }

    /**
     * @return the zoom_level
     */
    public int getZoom_level() {
        return zoom_level;
    }

    /**
     * @param zoom_level the zoom_level to set
     */
    public void setZoom_level(int zoom_level) {
        this.zoom_level = zoom_level;
    }
    /**
     * @param ratio the ratio to set
     */
}
