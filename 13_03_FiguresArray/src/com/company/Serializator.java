package com.company;

import java.io.*;

public class Serializator {
public boolean serialization(Figure figure, String fileName){
    boolean flag =false;
    File f = new File(fileName);
    ObjectOutputStream ostream = null;
    try{
        FileOutputStream fos = new FileOutputStream(f);
        if(fos!=null){
            ostream=new ObjectOutputStream(fos);
            ostream.writeObject(figure);
            flag=true;
        }

    } catch (FileNotFoundException e) {
        System.err.println("File can't be created:"+ e);
    } catch (NotSerializableException e){
        System.err.println("Class is not serialisable:"+ e);
    }catch (IOException e) {
        System.err.println(e);
    }
    finally {
        try{
            if(ostream!=null){
                ostream.close();
            }
        }catch (IOException e){
            System.err.println("Error with stream closing");
        }
    }
    return flag;
}
public Figure deserialization(String fileName) throws InvalidObjectException{
    File fr = new File(fileName);
    ObjectInputStream istream = null;
    try{
        FileInputStream fis = new FileInputStream(fr);
        istream= new ObjectInputStream(fis);
        Figure figure = (Figure)istream.readObject();
        return figure;
    }
    catch (ClassNotFoundException ce){
        System.err.println("Class is not exist:"+ce);
    } catch (FileNotFoundException e){
        System.err.println("File is not exist:"+e);
    } catch (InvalidClassException e){
        System.err.println("Classes are not the same:"+e);
    } catch (IOException e){
        System.err.println("IO error:"+e);
    } finally {
        try{
            if(istream!=null){
                istream.close();
            }
        }catch (IOException e){
            System.err.println("Error of stream closing");
        }
    }
    throw new InvalidObjectException("Object is not deserialized");
}
}
