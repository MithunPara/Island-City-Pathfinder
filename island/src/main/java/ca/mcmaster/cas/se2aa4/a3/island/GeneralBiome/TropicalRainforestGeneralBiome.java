package ca.mcmaster.cas.se2aa4.a3.island.GeneralBiome;

import ca.mcmaster.cas.se2aa4.a3.island.TilesTypes.TileTypes;

import java.awt.*;

public class TropicalRainforestGeneralBiome extends GeneralBiome {
    WhittakerDiagram tropicalRainforestWhittakerDiagram;

    public TropicalRainforestGeneralBiome(double getBaseTemperature){
        super(getBaseTemperature);
    }

    public void createWhittakerDiagram(double humidityRange, double minHumidity, double temperatureRange, double minTemperature){
        tropicalRainforestWhittakerDiagram = new WhittakerDiagram(humidityRange, minHumidity, temperatureRange, minTemperature);

        //Shapes altogether cover 0 - 100 on both axis
        tropicalRainforestWhittakerDiagram.addToWhittakerDiagram(new Rectangle(-1, -1,12,52), TileTypes.MUD);
        tropicalRainforestWhittakerDiagram.addToWhittakerDiagram(new Rectangle(-1,50,42,52), TileTypes.RAINFOREST);
        tropicalRainforestWhittakerDiagram.addToWhittakerDiagram(new Rectangle(10,-1,31,52), TileTypes.GRASSLAND);
        tropicalRainforestWhittakerDiagram.addToWhittakerDiagram(new Rectangle(40,-1,42,102), TileTypes.RAINFOREST);
        tropicalRainforestWhittakerDiagram.addToWhittakerDiagram(new Rectangle(80,80,21,21), TileTypes.RAINFOREST);
        tropicalRainforestWhittakerDiagram.addToWhittakerDiagram(new Rectangle(80,-1,21,82), TileTypes.SWAMP);
    }

    public TileTypes getTileBiome(double humidity, double temperature){
        return tropicalRainforestWhittakerDiagram.getBiome(humidity, temperature);
    }
}