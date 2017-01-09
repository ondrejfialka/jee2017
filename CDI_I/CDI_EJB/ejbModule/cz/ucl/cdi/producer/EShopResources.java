package cz.ucl.cdi.producer;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.Properties;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.SessionScoped;
import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;

import cz.ucl.cdi.annotation.Configuration;
import cz.ucl.cdi.annotation.ConfigurationFile;

@ApplicationScoped
public class EShopResources {
    @Produces   
    @ApplicationScoped
    @ConfigurationFile
    public Reader getConfigurationFile() {
        Reader result = null;

        try {
            result = new FileReader("D:/UCL/jee_workspace/jee2017/CDI_I/eshop_config.txt");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        
        return result;
    }

    public void closeConfigurationFile(@Disposes @ConfigurationFile Reader r) {
        try {
            r.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    @Produces
    @SessionScoped
    @Configuration
    public Properties getConfiguration(@ConfigurationFile Reader r) {
        Properties result = new Properties();
        try {
            result.load(r);
        } catch (IOException e) {           
            e.printStackTrace();
        }
        return result;
    }
}
