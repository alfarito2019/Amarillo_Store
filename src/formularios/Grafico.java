/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package formularios;

import java.awt.Color;
import org.jfree.chart.ChartFactory;

import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;


/**
 *
 * @author alfar
 */
public class Grafico {

    private static Color COLOR_SERIE_1 = new Color(255, 128, 64);

    private static Color COLOR_SERIE_2 = new Color(28, 84, 140);

    private static Color COLOR_RECUADROS_GRAFICA = new Color(31, 87, 4);

    private static Color COLOR_FONDO_GRAFICA = Color.white;

    public JFreeChart crearGrafica(DefaultCategoryDataset dataset) {

        final JFreeChart chart = ChartFactory.createBarChart("Compras a través del tiepo", "Fecha", "Cantidad",
                dataset,
                PlotOrientation.VERTICAL,
                true, // uso de leyenda
                false, // uso de tooltips  
                false // uso de urls
        );
        // color de fondo de la gráfica
        chart.setBackgroundPaint(COLOR_FONDO_GRAFICA);

        return chart;
    }

    // configuramos el contenido del gráfico (damos un color a las líneas que sirven de guía)
    
    
    
    
    
}
