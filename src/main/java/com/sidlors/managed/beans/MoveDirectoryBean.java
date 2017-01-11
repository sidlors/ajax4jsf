package com.sidlors.managed.beans;
import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;

public class MoveDirectoryBean{
	
	//Atributos del Bean
	private String origen="files\\";
	private String destino="repositorio\\";
	private String Dir="C:\\workarea\\workarea_watch\\"; //Aquí tenemos que mapear la ruta especificada para el work area que se encuentra en el build properties cron.batch.valid.filesystem 
	
	//Contructor por default
	public MoveDirectoryBean(){
		
	}
	
	//getters y setters de los atributos
	
	public void setDir(String Dir){
		this.Dir=Dir;
	}
	
	public String getDir(){
		return Dir;
	}
	
	
	//metodo que mueve los archivos del directorio files hacia directorio repositorio
	
	public int mueveDirectorio(){
		File srcDir = new File(Dir+origen);
		File destDir = new File(Dir+destino);

		try{
		FileUtils.copyDirectory(srcDir, destDir);
		}
		catch (IOException ex){
		}
		try{
		FileUtils.cleanDirectory(srcDir);
		}
		catch (IOException ex){
		}
		
		return 1;
	}
}