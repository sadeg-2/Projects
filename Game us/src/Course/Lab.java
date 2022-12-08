package Course;


import java.util.Date;

public class Lab{
    public static void main(String[] args) {
        System.out.println("Tomas Fucking Shilpy");
    }
}

class User {
    private String password ;
    private String username ;
    private MailAddress address ;

    public User() {
    }

    public User(String password, String username) {
        this.password = password;
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public String getUsername() {
        return username;
    }

    public MailAddress getAddress() {
        return address;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setAddress(MailAddress address) {
        this.address = address;
    }
}
class MailAddress{
    String firstName ;
    String lastName ;
    String email ;
    Message[] sent ;
    Message[] inbox ;
    public MailAddress() {
        sent = new Message[16];
        inbox = new Message[16];
    }
    public void sendMessage(Message message){
        int index = numberOfSentMessage();
        if (index==sent.length){
            System.out.println("the sent box is full");
            return;
        }
        sent[index] = message ;
    }

    public int numberOfSentMessage(){
        for (int i = 0; i < sent.length; i++) {
            if (sent[i] == null){
                return i ;
            }
        }
        return sent.length ;
    }
    public int numberOfReceivedMessage(){
        for (int i = 0; i < inbox.length; i++) {
            if (inbox[i] == null){
                return i ;
            }
        }
        return 0 ;
    }



}
class Message {
    MailAddress from ;
    MailAddress to ;
    MailAddress cc ;
    boolean isRead ;
    boolean isSent ;
    String subject ;
    String content ;
    Date date ;
    Attachment[] attachments ;

    public void removeAttachment (int index){
        for (int i = index; i < attachments.length -1 ; i++) {
            attachments[i] = attachments[i+1];
        }
        attachments[attachments.length -1] = null ;
    }
    public void clearReplyTo(){

    }
}
class Attachment{
    private String name;
    private String extension ;
    private int size;

    public Attachment() {
    }

    public Attachment(String name, String extension, int size) {
        this.name = name;
        this.extension = extension;
        this.size = size;
    }

    public String getName() {
        return name;
    }

    public String getExtension() {
        return extension;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getSize() {
        return size;
    }
}
