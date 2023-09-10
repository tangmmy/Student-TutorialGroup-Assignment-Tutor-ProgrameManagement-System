
package Database;

import Adt.*;
import Entity.*;
/**
 *
 * @author Li Hao
 */
public class TutorInitializer {
    
  
   public lihaoListInterface<Tutor> tutorInitializer(){
       
       lihaoListInterface<Tutor> tutorList = new lihaoLinkedList<>();
                        
       tutorList.add(new Tutor(1,"John Smith","012-3456789","Phd"));
       tutorList.add(new Tutor(2,"Albert","011-5452781","Master"));
       tutorList.add(new Tutor(1,"Darren","013-1426709","Master"));
       tutorList.add(new Tutor(2,"Mr Tan","014-7158799","Master"));
       tutorList.add(new Tutor(1,"Miss Lee","015-7486781","Phd"));
       tutorList.add(new Tutor(1,"Jenny","016-3156982","Master"));
       tutorList.add(new Tutor(2,"Dylon Lim","017-2456189","Degree"));
       tutorList.add(new Tutor(1,"Mohammad Ali","018-7456689","Master"));
       tutorList.add(new Tutor(1,"Mr Muttu","019-3436989","Phd"));
       tutorList.add(new Tutor(2,"Luqman","012-3451799","Degree"));
                    
       return tutorList;    
   }
       
}
