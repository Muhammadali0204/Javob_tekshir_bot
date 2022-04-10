import com.sun.jdi.request.StepRequest;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.ParseMode;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.CallbackQuery;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.*;


public class Bot extends TelegramLongPollingBot {

    int test_kodi = 100;


    ArrayList<Tuzgan_savollar> tuzgan_savollar_arrayList = new ArrayList<>();
    ArrayList<Berilgan_javoblar> berilgan_javoblar_arrayList = new ArrayList<>();

    @Override
    public String getBotUsername() {
        return "Javob_tekshir_bot";
    }

    @Override
    public String getBotToken() {
        return "5277451412:AAELgo6IeI1d6C_Wtns4oB0XBM9omnz64hc";
    }

    @Override
    public void onUpdateReceived(Update update) {

        System.out.println(update.getMessage().getText());
        System.out.println(update.getMessage().getFrom().getUserName());

        String toxtatilyotgan_kod = "";
        SendMessage sendMessage = new SendMessage();
        SendMessage sendMessage_test_egasi1 = new SendMessage();

        try {
            if (update.hasMessage()) {
                Message message = update.getMessage();
                if (message.hasText()) {

                    String xabar = message.getText();
                    sendMessage.setChatId(update.getMessage().getChatId().toString());


                    if (xabar.equals("/start")) {

                        sendMessage.setText("Salom, Xush kelibsiz!");

                        execute(sendMessage);
                    }
                    if (xabar.equals("/help")) {

                        sendMessage.setText("Botdan foydalanish : \n\n" +
                                "1. Test tuzish uchun: \n" +
                                "test*Fan nomi*abcdabcd...\n" +
                                "ko`rinishida yuboriladi.Sizga test kodi beriladi.\n" +
                                "2. Javoblarni tekshirish uchun : \n" +
                                "Berilgan test kodi+javoblar' ko`rinishida yuboriladi\n\n" +
                                "kod+abcdabcd...\n\n" + "(❗Diqqat❗  Savollar sonidan ko`p yoki oz javob yuborish mumkin emas!)\n" +
                                "Testni yakunlash uchun  end/test_kodi  ko`rinishida yuborishingiz mumkin."

                        );
                        execute(sendMessage);
                    }


                    //----------------------------betaraf hudud---------------------------------------------------

                    String test_tuzish_kaliti = "";
                    for (int i = 0; i < xabar.length(); i++) {
                        if (xabar.charAt(i) != '*') {
                            test_tuzish_kaliti += xabar.charAt(i);
                        } else
                            break;
                    }


                    int pluslar_soni = 0;
                    for (int i = 0; i < xabar.length(); i++) {
                        if (xabar.charAt(i) == '+') {
                            pluslar_soni++;
                        }
                    }

                    String end_kalit_sozi = "";
                    for (int i = 0; i < 3; i++) {
                        end_kalit_sozi += xabar.charAt(i);
                    }

// ---------------------------------------betaraf hudud quyisi----------------------------------------------


                    // ----------------------------Test tuzish----------------------------------------------------------


                    if (test_tuzish_kaliti.equals("test")) {
                        int yulduzchalar_soni = 0;
                        for (int i = 0; i < xabar.length(); i++) {
                            if (xabar.charAt(i) == '*') {
                                yulduzchalar_soni++;
                            }
                        }
                        if (yulduzchalar_soni == 2) {
                            String Fan_nomi = "";
                            for (int i = 5; i < xabar.length(); i++) {
                                if (xabar.charAt(i) != '*') {
                                    Fan_nomi += xabar.charAt(i);
                                } else break;
                            }

                            String ornatilgan_javob = "";
                            int ornatilgan_javoblar_soni = 0;
                            for (int i = 6 + Fan_nomi.length(); i < xabar.length(); i++) {
                                ornatilgan_javob += xabar.charAt(i);
                                ornatilgan_javoblar_soni++;
                            }

                            if (ornatilgan_javob != "" && Fan_nomi != "") {

                                Tuzgan_savollar tuzgan_savollar = new Tuzgan_savollar(test_kodi, Fan_nomi, ornatilgan_javob, ornatilgan_javoblar_soni, update.getMessage().getFrom().getId().toString());
                                tuzgan_savollar_arrayList.add(tuzgan_savollar);

                                test_kodi++;
                                if (test_kodi == 100000) {
                                    test_kodi = 100;
                                }

                                sendMessage.setChatId(update.getMessage().getChatId().toString());
                                sendMessage.setText("Testlar kaliti muvaffaqqiyatli qo`shildi! ✅\n" +
                                        "Test kodi : " + tuzgan_savollar.getKodi() + "\n" +
                                        "Javoblarni  testkodi+test javoblari ko`rinishida \n\n" +
                                        "@Javob_tekshir_bot  ga\n\n" +
                                        "yuborishingiz mumkin." +
                                        "Barchaga omad !!!");

                                execute(sendMessage);
                            }
                        }
                    }

                    //------------------------------test tuzish tugadi ---------------------------------------------------------


                    //-----------------------------javob berish -----------------------------------------------------------


                    if (pluslar_soni == 1) {
                        Berilgan_javoblar berilgan_javoblar;
                        String foydalanuvchi_yozgan_kodi = "";
                        for (int i = 0; i < xabar.length(); i++) {
                            if (xabar.charAt(i) != '+') {
                                foydalanuvchi_yozgan_kodi += xabar.charAt(i);
                            } else break;
                        }


                        String foydalanuvchi_bergan_javobi = "";
                        int foydalanuvchi_bergan_javoblar_soni = 0;
                        for (int i = 1 + foydalanuvchi_yozgan_kodi.length(); i < xabar.length(); i++) {
                            foydalanuvchi_bergan_javobi += xabar.charAt(i);
                            foydalanuvchi_bergan_javoblar_soni++;
                        }
                        if (berilgan_javoblar_arrayList.size() == 0) {
                            berilgan_javoblar_arrayList.add(new Berilgan_javoblar(1, "0", 0, "0", "0"));
                        }

                        int toplagan_bali = 0;
                        int javob_bergan = 0;
                        for (int i = 0; i < berilgan_javoblar_arrayList.size(); i++) {
                            if (berilgan_javoblar_arrayList.get(i).getId().equals(String.valueOf(update.getMessage().getFrom().getId()))) {
                                if (berilgan_javoblar_arrayList.get(i).getTest_kodi() != Integer.parseInt(foydalanuvchi_yozgan_kodi)) {
                                    javob_bergan++;
                                }
                            } else {
                                javob_bergan++;
                            }
                        }
                        if (javob_bergan == berilgan_javoblar_arrayList.size()) {
                            for (int i = 0; i < tuzgan_savollar_arrayList.size(); i++) {
                                if (Integer.parseInt(foydalanuvchi_yozgan_kodi) == tuzgan_savollar_arrayList.get(i).getKodi()) {
                                    if (foydalanuvchi_bergan_javoblar_soni == tuzgan_savollar_arrayList.get(i).getHaqiqiy_javoblar_soni()) {


                                        for (int j = 0; j < foydalanuvchi_bergan_javobi.length(); j++) {
                                            if (tuzgan_savollar_arrayList.get(i).getHaqiqiy_javob().charAt(j) == foydalanuvchi_bergan_javobi.charAt(j)) {
                                                toplagan_bali++;
                                            }
                                        }


                                        berilgan_javoblar = new Berilgan_javoblar(Integer.parseInt(foydalanuvchi_yozgan_kodi),
                                                update.getMessage().getFrom().getFirstName(), toplagan_bali, update.getMessage().getFrom().getUserName(),
                                                String.valueOf(update.getMessage().getFrom().getId()));

                                        berilgan_javoblar_arrayList.add(berilgan_javoblar);


                                        sendMessage.setChatId(update.getMessage().getChatId().toString());
                                        sendMessage.setText("Test kodi : " + foydalanuvchi_yozgan_kodi +
                                                "\nFan nomi : " + tuzgan_savollar_arrayList.get(i).getFan_nomi() +
                                                "\nSavollar soni : " + foydalanuvchi_bergan_javoblar_soni + " ta" +
                                                "\n✅To`g`ri javoblar soni : " + toplagan_bali + " ta\n" +
                                                "❌Noto`g`ri javoblar soni : " + (foydalanuvchi_bergan_javoblar_soni - toplagan_bali) + " ta");

                                        execute(sendMessage);

                                        sendMessage_test_egasi1.setChatId(tuzgan_savollar_arrayList.get(i).getId());
                                        sendMessage_test_egasi1.setText("Test kodi : " + berilgan_javoblar.getTest_kodi() + "\n" +
                                                berilgan_javoblar.getIsmi() + "(@" + update.getMessage().getFrom().getUserName() + ") javob berdi." +
                                                "\nTestni tugatish uchun  end/" + berilgan_javoblar.getTest_kodi() + "  ko`rinishida yuboring");

//                                        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
//                                        List<List<InlineKeyboardButton>> katta_list = new ArrayList<>();
//                                        List<InlineKeyboardButton> kichik_list = new ArrayList<>();
//                                        InlineKeyboardButton inlineKeyboardButton1 = new InlineKeyboardButton();
//                                        inlineKeyboardButton1.setText("Ko`rish");
//                                        inlineKeyboardButton1.setCallbackData("Jadval");
//                                        InlineKeyboardButton inlineKeyboardButton2 = new InlineKeyboardButton();
//                                        inlineKeyboardButton2.setText("Tugatish");
//                                        inlineKeyboardButton2.setCallbackData("Tugasin");
//                                        kichik_list.add(inlineKeyboardButton1);
//                                        kichik_list.add(inlineKeyboardButton2);
//                                        katta_list.add(kichik_list);
//                                        inlineKeyboardMarkup.setKeyboard(katta_list);
//                                        sendMessage_test_egasi1.setReplyMarkup(inlineKeyboardMarkup);
                                        execute(sendMessage_test_egasi1);



                                    }
                                }
                            }
                        }
                        else{
                            sendMessage.setText("Siz " + foydalanuvchi_yozgan_kodi +  " - kodli testga javob berib bo`lgansiz");
                            execute(sendMessage);
                        }
                    }

                    // ---------------------------------Javob berish tugadi------------------------------------------------


                    //------------------------------------------Testni tugatish-------------------------------------------


                    System.out.println(end_kalit_sozi); ///
                    if (end_kalit_sozi.equals("end")){
                        int tayoq = 0;
                        for (int i = 0; i < xabar.length(); i++) {
                            if (xabar.charAt(i) =='/'){
                                tayoq++;
                            }
                        }
                        System.out.println(tayoq);  ///
                        if (tayoq == 1){
                            String tugatilayotgan_test_kodi = "";
                            for (int i = 4; i < xabar.length(); i++) {
                                tugatilayotgan_test_kodi += xabar.charAt(i);
                            }
                            for (int i = 0; i < tuzgan_savollar_arrayList.size(); i++) {
                                if (tuzgan_savollar_arrayList.get(i).getKodi() == Integer.parseInt(tugatilayotgan_test_kodi)){
                                    if (tuzgan_savollar_arrayList.get(i).getId().equals(String.valueOf(update.getMessage().getFrom().getId()))){
                                        String jadval = "";
                                        int tartibi = 1;
                                        String maqtov = "";
                                        System.out.println("ishlayapti");
                                        for (int j = 0; j < berilgan_javoblar_arrayList.size(); j++) {
                                            if (Integer.parseInt(tugatilayotgan_test_kodi) == berilgan_javoblar_arrayList.get(j).getTest_kodi()){
                                                if (tartibi == 1){
                                                    maqtov = "\uD83E\uDD47";
                                                }
                                                if (tartibi == 2){
                                                    maqtov = "\uD83E\uDD48";
                                                }
                                                else if (tartibi == 3){
                                                    maqtov = "\uD83E\uDD49";
                                                }
                                                if (berilgan_javoblar_arrayList.get(j).getUsername() != null) {
                                                    jadval += tartibi + " " + berilgan_javoblar_arrayList.get(j).getIsmi() + "(@" + berilgan_javoblar_arrayList.get(j).getUsername()
                                                            + ") " + berilgan_javoblar_arrayList.get(j).getToplagan_bali() + " ta " + maqtov + "\n";
                                                    tartibi++;
                                                }
                                                else if (berilgan_javoblar_arrayList.get(j).getUsername() == null){
                                                    jadval += tartibi + " " + berilgan_javoblar_arrayList.get(j).getIsmi() +  " "
                                                            + berilgan_javoblar_arrayList.get(j).getToplagan_bali() + " ta " + maqtov + "\n";
                                                    tartibi++;
                                                }
                                            }
                                        }
                                        System.out.println(jadval);
                                        sendMessage.setText(jadval);
                                        sendMessage.setChatId(update.getMessage().getFrom().getId().toString());
                                        sendMessage.setParseMode(ParseMode.HTML);
                                        execute(sendMessage);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }catch (TelegramApiException e){
            e.printStackTrace();
        }
    }
}