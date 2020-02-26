package entity.controller;

import entity.*;
import entity.enums.MaritalStatus;
import entity.enums.Sex;
import entity.enums.TypeOfPhone;
import util.ConnectorDB;

import java.sql.*;
import java.text.SimpleDateFormat;

public class ServerManager {
    private final static String SQL_GET_CONTACT_INFO_BY_ID = "select * from contactinfo where Id=? ";
    private final static String SQL_GET_ATTACHMENTS_BY_ID = "select * from attachments where Id=? ";
    private final static String SQL_GET_TELEPHONE_NUMBER_BY_ID = "select * from telephonenumber where Id=?";
    private final static String SQL_GET_SHORT_CONTACT_BY_ID = "select * from contacts where Id=?";
    private final static String SQL_INSERT_ATTACHMENTS="insert into mydb.attachments(Id,NameOfAttachment,Date,Commentary) values(?,?,?,?)";
    private final static String SQL_INSERT_CONTACT_INFO="insert into mydb.contactinfo (Id, Name, SurName, MiddleName, DateOfBirth, Sex, Citizenship, MaritalStatus,WebSite, Email,PlaceOfWork, Address) values (?, ?, ?, ?,?,?,?,?,?,?,?,?)";
    private final static String SQL_INSERT_TELEPHONE_NUMBER="insert into mydb.telephonenumber (Id, CodeOfCountry,CodeOfOperator,TelephoneNumbercol,TypeOfPhone,Commentary) values (?,?,?,?,?,?)";
    private final static String SQL_INSERT_SHORT_CONTACT = "insert int mydb.contacts(Id,ContactInfoId,TelephoneNumberId,AttachmentId) values (?,?,?,?)";
    private Connection connection;

    public ServerManager() throws SQLException {
        this.connection = ConnectorDB.getConnection();;
    }

    public void closeConnection() throws SQLException {
        connection.close();
    }

    public Attachment getAttachmentsById(final int id){
        PreparedStatement ps = null;
        try{
            ps = connection.prepareStatement(SQL_GET_ATTACHMENTS_BY_ID);
            ps.setString(1,String.valueOf(id));
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Attachment resultAttachment = new Attachment();
                resultAttachment.setId(id);
                resultAttachment.setNameOfFile(rs.getString(2));
                resultAttachment.setDateOfDownload(rs.getDate(3));
                resultAttachment.setCommentary(rs.getString(4));
                return resultAttachment;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void insertAttachments(Attachment attachment){
        PreparedStatement ps = null;
        try{
            ps = connection.prepareStatement(SQL_INSERT_ATTACHMENTS);
            ps.setInt(1,attachment.getId());
            ps.setString(2, attachment.getNameOfFile());
            ps.setString(3,attachment.getDateOfDownload().toString());
            ps.setString(4,attachment.getCommentary());
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Contact getContactInfoById(final int id) {
        PreparedStatement ps = null;
        try {
            ps = connection.prepareStatement(SQL_GET_CONTACT_INFO_BY_ID);
            ps.setString(1, String.valueOf(id));

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Contact resultContact = new Contact();
                resultContact.setId(id);
                resultContact.setFirstName(rs.getString(2));
                resultContact.setSurName(rs.getString(3));
                resultContact.setMiddleName(rs.getString(4));
                resultContact.setDateOfBirth(rs.getDate(5));
                resultContact.setSex(Sex.valueOf(rs.getString(6)));
                resultContact.setCitizenship(rs.getString(7));
                resultContact.setMaritalStatus(MaritalStatus.valueOf(rs.getString(8)));
                resultContact.setWebSite(rs.getString(9));
                resultContact.setEmail(rs.getString(10));
                resultContact.setPlaceOfWork(rs.getString(11));
                resultContact.setAddress(rs.getString(12));
                return resultContact;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void insertContactInfo(Contact contact) {
        PreparedStatement ps = null;
        try{
            ps = connection.prepareStatement(SQL_INSERT_CONTACT_INFO);
            ps.setString(1,String.valueOf(contact.getId()));
            ps.setString(2,String.valueOf(contact.getFirstName()));
            ps.setString(3,String.valueOf(contact.getSurName()));
            ps.setString(4,String.valueOf(contact.getMiddleName()));
            ps.setString(5,String.valueOf(contact.getDateOfBirth().toString()));
            ps.setString(6,String.valueOf(contact.getSex().toString()));
            ps.setString(7,String.valueOf(contact.getCitizenship()));
            ps.setString(8,String.valueOf(contact.getMaritalStatus().toString()));
            ps.setString(9,String.valueOf(contact.getWebSite()));
            ps.setString(10,String.valueOf(contact.getEmail()));
            ps.setString(11,String.valueOf(contact.getPlaceOfWork()));
            ps.setString(12,String.valueOf(contact.getAddress()));
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public TelephoneNumber getTelephoneNumberById(final int id){
        PreparedStatement ps = null;
        try{
            ps = connection.prepareStatement(SQL_GET_TELEPHONE_NUMBER_BY_ID);
            ps.setString(1,String.valueOf(id));
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                TelephoneNumber resultTelephoneNumber = new TelephoneNumber();
                resultTelephoneNumber.setId(rs.getInt(1));
                resultTelephoneNumber.setCodeOfCountry(rs.getInt(2));
                resultTelephoneNumber.setCodeOfOperator(rs.getInt(3));
                resultTelephoneNumber.setPhoneNumber(rs.getInt(4));
                resultTelephoneNumber.setTypeOfPhone(TypeOfPhone.valueOf(rs.getString(5)));
                resultTelephoneNumber.setCommentary(rs.getString(6));
                return resultTelephoneNumber;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void insertTelephoneNumber(TelephoneNumber telephoneNumber){
        PreparedStatement ps = null;
        try{
            ps = connection.prepareStatement(SQL_INSERT_TELEPHONE_NUMBER);
            ps.setString(1,String.valueOf(telephoneNumber.getId()));
            ps.setString(2,String.valueOf(telephoneNumber.getCodeOfCountry()));
            ps.setString(3,String.valueOf(telephoneNumber.getCodeOfOperator()));
            ps.setString(4,String.valueOf(telephoneNumber.getPhoneNumber()));
            ps.setString(5,String.valueOf(telephoneNumber.getTypeOfPhone()));
            ps.setString(6,String.valueOf(telephoneNumber.getCommentary()));
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void insertShortContact(ShortContact shortContact){
        PreparedStatement ps = null;
        try{
            ps = connection.prepareStatement(SQL_INSERT_SHORT_CONTACT);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        try {
            SimpleDateFormat format =  new SimpleDateFormat("yyyy-mm-dd");
            Date date = Date.valueOf("2001-03-09");
            Address address = new Address("Belarus","Minsk","Belskogo",18,60);
            Contact yan = new Contact(1,"Yan","Zhigarev","Uladzimiravich", date , Sex.MALE,"Belarus", MaritalStatus.IDLE ,"","zhigarevyan@gmail.com", address,"ITechArt");
            Attachment attachment = new Attachment(1,"AttachmentName",date,"Commentary");
            TelephoneNumber t = new TelephoneNumber(1,375,29,3233751,TypeOfPhone.MOBILE,"My TelNum");
            ServerManager manager = new ServerManager();
            //manager.insertTelephoneNumber(t);
            //manager.insertAttachments(attachment);
            //manager.insertContactInfo(yan);
            Contact findContact = manager.getContactInfoById(1);
            Attachment findAttachment = manager.getAttachmentsById(1);
            TelephoneNumber findTelephoneNumber =  manager.getTelephoneNumberById(1);
            System.out.println(findAttachment);
            System.out.println(findContact);
            System.out.println(findTelephoneNumber);

            System.out.println(t);
        } catch (SQLException  e) {
            e.printStackTrace();
        }
    }
}

