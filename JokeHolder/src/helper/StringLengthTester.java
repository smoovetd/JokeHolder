package helper;

import java.io.*;
import java.util.*;

public class StringLengthTester{
  public static void main(String args[]) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sbText = new StringBuilder();

    String text = "Действам на принципа колкото парите, толкова и музиката." +
                  "Също така, изобщо не ме интересува, че сте на загуба и очаквам, че всички законови задължения ще изпълните навреме, и че ще спазвате всички празници, както и годишния ми отпуск." +
"Факт е, че ще ви напусна веднага, щом открия по-подходяща работа с по-големи шансове за растеж." +
"Комуникативен съм с приятни и учтиви обноски, но за дразнителите фитилът ми е много къс." +
"Псувам на няколко световни езика, но сериозна кореспонденция и разговор мога да водя само на майчин език и на английски, и не се фукайте с мултинационалността на компанията, тъй като и това, което ви предлагам, ви е много." +
"Това, че от време на време, реализирате сделка със Сърбия, Босна, Хърватия или Словения, не ви прави сериозна мултинационална компания." +
"Следвах 100 години, но смятам, че е успех, че изобщо и завърших факултет в тази страна, каквато е тя към настоящия момент." +
"Усъвършенствам се непрекъснато и без вас, защото съм любопитен човек и мисля, че животът има смисъл и без да се съсипеш от работа." +
"Реагирам само на положителна стимулация." +
"Недейте да ме тормозите с тестове и тийм-билдинг глупости." +
"Ако вече си падате по такива европейски 'изпълнения', тогава осигурете ми и европейска заплата и условия на труд." +
"Това, че сте били на два, три семинара, не ви прави образована личност." +
"Което не знам, ще науча, не съм дебил." +
"И, да, има неща в живота, които бих правил от чист ентусиазъм, но за съжаление трябва да ви кажа, че работата, която предлагате, не е едно от тях.";

  do {
    String text2 = br.readLine();
    if(text2.equals("#DONE#")){
      break;
    }
    sbText.append(text2);
  } while (true);

  String fulltext = sbText.toString();

  System.out.println("=================== 1 ===================");
  System.out.println(text);
  System.out.println("Length: " + text.length());
  System.out.println("=================== 2 ===================");
  System.out.println(fulltext);
  System.out.println("Length: " + fulltext.length());
  System.out.println("=================== 1 = 2 ===================");
  System.out.println(fulltext.equals(text));
  }
}
