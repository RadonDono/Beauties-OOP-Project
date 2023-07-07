import java.util.UUID;

public class GetRandomID
{
//    this class gives you random unique IDs !!!
   static int getID(){
       UUID uuid=UUID.randomUUID();
       int ID=uuid.hashCode();
       return ID;
   }


}
