package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;

public class Main extends Application {

    private NumberAxis x=new NumberAxis();
    private NumberAxis y=new NumberAxis();

    private LineChart<Number,Number> lineChart=new LineChart<Number,Number>(x,y);
    private boolean isRunning=true;

    private XYChart.Series appSeries=new XYChart.Series();
    private XYChart.Series series=new XYChart.Series();
    private Thread thread;
    private double[] sp=new double[1000];

    @Override
    public void start(Stage primaryStage) throws Exception{

        thread=new Thread(new Runnable() {
            @Override
            public void run() {
                /*for (double i = 0; i < Fourier.dx * 1001; i += Fourier.dx) {
                    if(!isRunning)
                        return;
                    appSeries.getData().add(new XYChart.Data(i,Fourier.fourierCalc(i)));
                    series.getData().add(new XYChart.Data(i,Fourier.F(i)));
                }*/

            }
        });

        //thread.start();

        for(int i=0;i<1000;i++)
        {
            if(!isRunning)
                return;
            //sp[i]=Fourier.spectrum(i);
            appSeries.getData().add(new XYChart.Data(i,Fourier.spectrum(i)));
        }
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(lineChart, 800, 600));
        appSeries.setName("Fourier(x)");
        series.setName("F(x)");
        lineChart.getData().add(appSeries);
        lineChart.getData().add(series);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void stop()
    {
        isRunning=false;
    }
}
