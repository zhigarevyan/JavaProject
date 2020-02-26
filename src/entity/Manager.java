package entity;

import java.io.*;
import java.util.List;

public class Manager implements Serializable {
    private List list;

    public Manager(List list) {
        this.list = list;
    }

    public void changeList(List list)
    {
        this.list = list;
    }
    public void add(Object o) {
        list.add(o);
    }

    public void Delete(Object o) {
        list.remove(o);
    }

    public Object Get(Object o) {
        return list.get(list.indexOf(o));
    }
    public void saveAddress()
    {
        try(ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("Adress.dat")))
        {
            objectOutputStream.writeObject(list);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void saveAttachment()
    {
        try(ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("Attachment.dat")))
        {
            objectOutputStream.writeObject(list);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void saveContact()
    {
        try(ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("Contact.dat")))
        {
            objectOutputStream.writeObject(list);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void saveTelephoneNumber()
    {
        try(ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("TelephoneNumber.dat")))
        {
            objectOutputStream.writeObject(list);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void SaveAll()
    {
        this.saveAddress();
        this.saveAttachment();
        this.saveContact();
        this.saveTelephoneNumber();
    }

    public List loadAddress()
    {
        try(ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("Adress.dat")))
        {
            return (List)objectInputStream.readObject();
        } catch (FileNotFoundException | ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
    public List loadContact()
    {
        try(ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("Contact.dat")))
        {
            return (List)objectInputStream.readObject();
        } catch (ClassNotFoundException | IOException e) {
            e.printStackTrace();
        }
        return null;
    }
    public List loadAttachment()
    {
        try(ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("Attachment.dat")))
        {
            return (List)objectInputStream.readObject();
        } catch (FileNotFoundException | ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
    public List loadTelephoneNumber()
    {
        try(ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("TelephoneNumber.dat")))
        {
            return (List)objectInputStream.readObject();
        } catch (FileNotFoundException | ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }




}
