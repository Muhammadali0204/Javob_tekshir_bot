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
        SendMessage sendMessage_test_egasi2 = new SendMessage();

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
                                "kod+abcdabcd...\n\n" + "(❗Diqqat❗  Savollar sonidan ko`p yoki oz javob yuborish mumkin emas!)\n"

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

                    int yulduzchalar_soni = 0;
                    for (int i = 0; i < xabar.length(); i++) {
                        if (xabar.charAt(i) == '*') {
                            yulduzchalar_soni++;
                        }
                    }

                    int pluslar_soni = 0;
                    for (int i = 0; i < xabar.length(); i++) {
                        if (xabar.charAt(i) == '+') {
                            pluslar_soni++;
                        }
                    }

// ---------------------------------------betaraf hudud quyisi----------------------------------------------


                    // ----------------------------Test tuzish----------------------------------------------------------


                    if (test_tuzish_kaliti.equals("test")) {
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
                        System.out.println(berilgan_javoblar_arrayList.size());
                        System.out.println("Boshida " + berilgan_javoblar_arrayList);
                        int toplagan_bali = 0;
                        int javob_bergan = 0;
                        for (int i = 0; i < berilgan_javoblar_arrayList.size(); i++) {
                            if (berilgan_javoblar_arrayList.get(i).getId() == String.valueOf(update.getMessage().getFrom().getId())) {
                                if (berilgan_javoblar_arrayList.get(i).getTest_kodi() != Integer.parseInt(foydalanuvchi_yozgan_kodi)) {
                                    javob_bergan++;
                                }
                            } else {
                                javob_bergan++;
                            }
                        }
                        System.out.println(javob_bergan);
                        System.out.println(berilgan_javoblar_arrayList);
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
                                                update.getMessage().getFrom().getFirstName(), toplagan_bali, update.getMessage().getFrom().getUserName(), String.valueOf(update.getMessage().getFrom().getId()));

                                        berilgan_javoblar_arrayList.add(berilgan_javoblar);
                                        System.out.println(berilgan_javoblar_arrayList);


                                        sendMessage.setChatId(update.getMessage().getChatId().toString());
                                        sendMessage.setText("Test kodi : " + foydalanuvchi_yozgan_kodi +
                                                "\nFan nomi : " + tuzgan_savollar_arrayList.get(i).getFan_nomi() +
                                                "\nSavollar soni : " + foydalanuvchi_bergan_javoblar_soni + " ta" +
                                                "\n✅To`g`ri javoblar soni : " + toplagan_bali + " ta\n" +
                                                "❌Noto`g`ri javoblar soni : " + (foydalanuvchi_bergan_javoblar_soni - toplagan_bali) + " ta");

                                        execute(sendMessage);

                                        sendMessage_test_egasi1.setChatId(tuzgan_savollar_arrayList.get(i).getId());
                                        sendMessage_test_egasi1.setText("Test kodi : " + berilgan_javoblar.getTest_kodi() + "\n" +
                                                berilgan_javoblar.getIsmi() + "(@" + update.getMessage().getFrom().getUserName() + ") javob berdi.");

                                        execute(sendMessage_test_egasi1);

                                    }
                                }
                            }
                        }
                        else{
                            sendMessage.setText("Siz javob berib bo`lgansiz");
                            execute(sendMessage);
                        }
                    }
                }
            }
            else if (update.hasCallbackQuery()) {
                CallbackQuery callbackQuery = update.getCallbackQuery();
                callbackQuery.getData();

            }
        }catch (TelegramApiException e){
            e.printStackTrace();
        }
    }
}


//else {
//
//        sendMessage.setText("Siz bu testga javob berib bo`lgansiz");
//        sendMessage.setChatId(update.getMessage().getChatId().toString());
//        execute(sendMessage);
//        }