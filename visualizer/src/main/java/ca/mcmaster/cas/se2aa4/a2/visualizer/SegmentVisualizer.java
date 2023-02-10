package ca.mcmaster.cas.se2aa4.a2.visualizer;

import ca.mcmaster.cas.se2aa4.a2.io.Structs.Segment;
import ca.mcmaster.cas.se2aa4.a2.io.Structs.Property;
import java.awt.Color;
import java.awt.geom.Line2D;
import java.util.List;

public class SegmentVisualizer {
    Boolean drawn;
    Segment segment;

    public SegmentVisualizer(Segment segment)
    {
        this.drawn = false;
        this.segment = segment;
    }

    public int getVertedIDX1(){
        return segment.getV1Idx();
    }

    public int getVertedIDX2(){
        return segment.getV2Idx();
    }

    public boolean isDrawn()
    {
        return drawn;
    }
    public void draw(){
        drawn = true;
    }

    public Line2D getLine(double x1, double y1, double x2, double y2){
        Line2D line = new Line2D.Double(x1, y1, x2, y2);
        return line;
    }

    public Color getColor(){
        return extractColor(segment.getPropertiesList());
    }

    private Color extractColor(List<Property> properties) {
        String val = null;

        //Get the colour properties of the lines
        for(Property p: properties) {
            if (p.getKey().equals("rgb_color")) {
                System.out.println(p.getValue());
                val = p.getValue();
            }
        }

        if (val == null)
            return Color.BLACK;

        //Set the RGB values 
        String[] raw = val.split(",");
        int red = Integer.parseInt(raw[0]);
        int green = Integer.parseInt(raw[1]);
        int blue = Integer.parseInt(raw[2]);

        return new Color(red, green, blue);
    }
    
}
