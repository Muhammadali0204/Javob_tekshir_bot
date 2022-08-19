package org.Ali;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.ParseMode;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.AnswerCallbackQuery;
import org.telegram.telegrambots.meta.api.objects.CallbackQuery;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;


public class Bot extends TelegramLongPollingBot {
    @Override
    public String getBotUsername() {
        return "Javob_tekshir_bot";
    }

    @Override
    public String getBotToken() {
        return "5277451412:AAELgo6IeI1d6C_Wtns4oB0XBM9omnz64hc";
    }

    int test_kodi = 100;


    ArrayList<Tuzgan_savollar> tuzgan_savollar_arrayList = new ArrayList<>();
    ArrayList<Berilgan_javoblar> berilgan_javoblar_arrayList = new ArrayList<>();
    ArrayList<Ism_familiya> ismlar = new ArrayList<>();
    ArrayList<Admins> admins = new ArrayList<>();
    ArrayList<Start_bosganlar> startbosganlar = new ArrayList<>();
    FileWriter writer;
    FileReader reader;


    @Override
    public void onUpdateReceived(Update update) {


        SendMessage sendMessage = new SendMessage();
        SendMessage sendMessage2 = new SendMessage();
        SendMessage sendMessage_call_back = new SendMessage();
        SendMessage sendMessage_test_egasi1 = new SendMessage();
        AnswerCallbackQuery answer_call = new AnswerCallbackQuery();
        String ismlar_string = "";
        String tuzilgan_savollar_string = "";
        String berilgan_javoblar_string = "";
        String adminlar_string = "";
        String start_bosganlar_string = "";

        try {


            //   ----------------------------------------Fayllardan o`qish -----------------------------------------------------------

//            if (test_kodi == 1) {
//                if (!"test_kodi.txt".isEmpty()) {
//                    try {
//                        reader = new FileReader("src/main/java/org/Ali/test_kodi.txt");
//                        BufferedReader bufferred_reader = new BufferedReader(reader);
//                        String line = bufferred_reader.readLine();
//                        test_kodi = Integer.parseInt(line);
//                        reader.close();
//                    } catch (Exception e) {
//                        e.printStackTrace();
//                    }
//                }
//            }
//            if (admins.isEmpty()) {
//                reader = new FileReader("src/main/java/org/Ali/admins.txt");
//                BufferedReader bufferred_reader = new BufferedReader(reader);
//                String line = bufferred_reader.readLine();
//                while (line != null) {
//                    admins.add(new Admins(line));
//                    line = bufferred_reader.readLine();
//                }
//                reader.close();
//            }
//            if (ismlar.isEmpty()) {
//                if (!"ismlar.txt".isEmpty()) {
//                    try {
//                        reader = new FileReader("src/main/java/org/Ali/ismlar.txt");
//                        BufferedReader bufferred_reader = new BufferedReader(reader);
//                        String line = bufferred_reader.readLine();
//                        while (line != null) {
//                            String[] s;
//                            s = line.split("~");
//                            ismlar.add(new Ism_familiya(s[0], s[1]));
//                            line = bufferred_reader.readLine();
//                        }
//                        reader.close();
//                    } catch (Exception e) {
//                        e.printStackTrace();
//                    }
//                }
//            }
//
//            if (tuzgan_savollar_arrayList.size() == 0) {
//                if (!"tuzilgan_savollar.txt".isEmpty()) {
//                    try {
//                        reader = new FileReader("src/main/java/org/Ali/tuzilgan_savollar.txt");
//                        BufferedReader bufferred_reader = new BufferedReader(reader);
//                        String line = bufferred_reader.readLine();
//                        while (line != null) {
//                            String[] s = new String[6];
//                            s = line.split("~");
//                            tuzgan_savollar_arrayList.add(new Tuzgan_savollar(s[0], s[1], s[2], Integer.parseInt(s[3]), s[4], s[5]));
//                            line = bufferred_reader.readLine();
//                        }
//                        reader.close();
//                    } catch (Exception e) {
//                        e.printStackTrace();
//                    }
//                }
//            }
//
//            if (berilgan_javoblar_arrayList.size() == 0) {
//                if (!"berilgan_javoblar.txt".isEmpty()) {
//                    try {
//                        reader = new FileReader("src/main/java/org/Ali/berilgan_javoblar.txt");
//                        BufferedReader bufferred_reader = new BufferedReader(reader);
//                        String line = bufferred_reader.readLine();
//                        while (line != null) {
//                            String[] s;
//                            s = line.split("~");
//                            berilgan_javoblar_arrayList.add(new Berilgan_javoblar(s[0], s[1], Integer.parseInt(s[2]), s[3], s[4], s[5]));
//                            line = bufferred_reader.readLine();
//                        }
//                        reader.close();
//                    } catch (Exception e) {
//                        e.printStackTrace();
//                    }
//                }
//            }
//
//            if (startbosganlar.size() == 0) {
//                if (!"start_bosganlar.txt".isEmpty()) {
//                    try {
//                        reader = new FileReader("src/main/java/org/Ali/start_bosganlar.txt");
//                        BufferedReader bufferred_reader = new BufferedReader(reader);
//                        String line = bufferred_reader.readLine();
//                        while (line != null) {
//                            String[] s;
//                            s = line.split("~");
//                            startbosganlar.add(new Start_bosganlar(s[0], s[1]));
//                            line = bufferred_reader.readLine();
//                        }
//                        reader.close();
//                    } catch (Exception e) {
//                        e.printStackTrace();
//                    }
//                }
//            }

            // ----------------------------------------------Fayllardan o`qish tamom -------------------------------------------------


            if (update.hasMessage()) {

                Message message = update.getMessage();

                if (message.hasText()) {
                    int xabari_qanday = 0;
                    String xabar = message.getText();
                    int tolqin_bormi = 0;
                    for (int i = 0; i < xabar.length(); i++) {
                        if (xabar.charAt(i) == '~') {
                            tolqin_bormi++;
                        }
                    }
                    if (tolqin_bormi == 0) {
                        if (xabar.length() > 1) {

                            sendMessage.setChatId(update.getMessage().getChatId().toString());
                            sendMessage2.setChatId(update.getMessage().getChatId().toString());
                            sendMessage.setParseMode(ParseMode.HTML);
                            sendMessage2.setParseMode(ParseMode.HTML);

                            if (admins.size() == 0) {
                                admins.add(new Admins("804588100"));
                            }
                            if (ismlar.size() == 0) {
                                ismlar.add(new Ism_familiya("Mamadjonov Muhammadali", "804588100"));
                            }

//---------------------------------------/start buyrug`i --------------------------------------------------
                            if (xabar.equals("/start")) {
                                xabari_qanday = 1;
                                sendMessage.setText("Salom, Xush kelibsiz!");
                                execute(sendMessage);
                                int t = 0;
                                for (int i = 0; i < startbosganlar.size(); i++) {
                                    if (!String.valueOf(update.getMessage().getFrom().getId()).equals(startbosganlar.get(i).getId())) {
                                        t++;
                                    }
                                }
                                if (t == startbosganlar.size()) {
                                    startbosganlar.add(new Start_bosganlar(update.getMessage().getFrom().getFirstName(), String.valueOf(update.getMessage().getFrom().getId())));
//                                    writer = new FileWriter("src/main/java/org/Ali/start_bosganlar.txt");
//                                    for (int qwertr = 0; qwertr < startbosganlar.size(); qwertr++) {
//                                        start_bosganlar_string += startbosganlar.get(qwertr).getIsmi() + "~" + startbosganlar.get(qwertr).getId() + "\n";
//                                    }
//                                    writer.write(start_bosganlar_string);
//                                    writer.close();
                                }
                                int yoq = 0;
                                for (int i = 0; i < ismlar.size(); i++) {
                                    if (!ismlar.get(i).getId().equals(String.valueOf(update.getMessage().getFrom().getId()))) {
                                        yoq++;
                                    }
                                }
                                if (yoq == ismlar.size()) {
                                    sendMessage2.setText("Familiya ismingizni namunadagidek kiriting : \n" +
                                            "Namuna : If*Ism familiya");
                                    execute(sendMessage2);
                                }
                            }
                            //-----------help -------------------------------------------------------------------------------------------------
                            else if (xabar.equals("/help")) {
                                xabari_qanday = 1;

                                sendMessage.setText("\uD83E\uDD16 Botdan foydalanish : \n\n" +
                                        "1️⃣.Botdan foydalana olishingiz uchun quyidagi ko`rinishda ism familiyangizni botga jo`nating : \n\n" +
                                        "   If*Ism familya  \n\n" +
                                        "2️⃣. Test tuzish uchun: \n\n" +
                                        "   Test*Fan nomi*Test javoblari\n\n" +
                                        "ko`rinishida yuboriladi.Sizga test kodi beriladi.\n\n" +
                                        "Namuna : Test*Matematika*abcdabcd...\n\n" +
                                        "3️⃣. Javoblarni tekshirish uchun : \n\n" +
                                        "   Berilgan test kodi*javoblar\n\n ko`rinishida yuboriladi\n\n" +
                                        "Namuna :  777*abcdabcd...\n\n" + "(❗Diqqat❗  Savollar sonidan ko`p yoki oz javob yuborish mumkin emas!)\n"
                                );
                                execute(sendMessage);
                            }
                            //---------------test ------------------------------------------------------------------------
                            else if (xabar.equals("/test")) {
                                xabari_qanday = 1;
                                String id = update.getMessage().getFrom().getId().toString();
                                String testlarim = "";
                                int p = 1;
                                for (int i = 0; i < tuzgan_savollar_arrayList.size(); i++) {
                                    if (tuzgan_savollar_arrayList.get(i).getId().equals(id)) {
                                        int k = 0;
                                        for (int j = 0; j < berilgan_javoblar_arrayList.size(); j++) {
                                            if (tuzgan_savollar_arrayList.get(i).getKodi() == berilgan_javoblar_arrayList.get(j).getTest_kodi()) {
                                                k++;
                                            }
                                        }
                                        testlarim += (p + ". Test kodi - " + tuzgan_savollar_arrayList.get(i).getKodi() + "\nFan nomi - "
                                                + tuzgan_savollar_arrayList.get(i).getFan_nomi()
                                                + "\nBerilgan javoblar soni - " + k + " ta\n");
                                        p++;
                                    }
                                }
                                if (p != 1) {
                                    sendMessage.setText(testlarim);
                                    execute(sendMessage);
                                } else if (p == 1) {
                                    sendMessage.setText("Siz tuzgan faol testlar mavjud emas!");
                                    execute(sendMessage);
                                }
                            }


                            String Iff = "";

                            for (int i = 0; i < 2; i++) {
                                Iff += xabar.charAt(i);
                            }
// ----------------------------------------------------Ism familiya yozish ------------------------------------------------------------
                            if (Iff.equals("If") || Iff.equals("if")) {
                                if (xabar.charAt(2) == '*') {
                                    xabari_qanday = 1;
                                    String ismi = "";
                                    for (int i = 3; i < xabar.length(); i++) {
                                        ismi += xabar.charAt(i);
                                    }
                                    if (ismi != "") {
                                        int bormi = 0;
                                        for (int i = 0; i < ismlar.size(); i++) {
                                            if (!ismlar.get(i).getId().equals(update.getMessage().getFrom().getId().toString())) {
                                                bormi++;
                                            } else {
                                                ismlar.get(i).setIsm_familiya(ismi);
                                                sendMessage.setText("\uD83D\uDD04 Ism familiyangiz " + ismi + "'ga o`zgartirildi!");
//                                                try {
//                                                    writer = new FileWriter("src/main/java/org/Ali/ismlar.txt");
//                                                    for (int qwewq = 0; qwewq < ismlar.size(); qwewq++) {
//                                                        ismlar_string += ismlar.get(qwewq).getIsm_familiya() + "~" + ismlar.get(qwewq).getId() + "\n";
//                                                    }
//                                                    writer.write(ismlar_string);
//                                                    writer.close();
//                                                } catch (IOException e) {
//                                                    e.printStackTrace();
//                                                }

                                                execute(sendMessage);
                                            }
                                        }
                                        if (bormi == ismlar.size()) {
                                            ismlar.add(new Ism_familiya(ismi, update.getMessage().getFrom().getId().toString()));
//                                            try {
//                                                writer = new FileWriter("src/main/java/org/Ali/ismlar.txt");
//                                                for (int i = 0; i < ismlar.size(); i++) {
//                                                    ismlar_string += ismlar.get(i).getIsm_familiya() + "~" + ismlar.get(i).getId() + "\n";
//                                                }
//                                                writer.write(ismlar_string);
//                                                writer.close();
//                                            } catch (IOException e) {
//                                                e.printStackTrace();
//                                            }
                                            sendMessage.setText("Tabriklaymiz " + ismi + " !!! Botdan foydalanishingiz mumkin.✅");
                                            execute(sendMessage);
                                        }
                                    } else {
                                        sendMessage.setText("Ism familiyangiz bo`sh bo`lishi mumkin emas ❗️");
                                        execute(sendMessage);
                                    }
                                }
                            }

                            int ismi_bor = 0;

                            for (int i = 0; i < ismlar.size(); i++) {
                                if (!ismlar.get(i).getId().equals(update.getMessage().getFrom().getId().toString())) {
                                    ismi_bor++;
                                }
                            }
                            for (int i = 0; i < admins.size(); i++) {
                                if (String.valueOf(update.getMessage().getFrom().getId()).equals(admins.get(i).getId())) {
                                    if (xabar.equals("Admin")) {
                                        xabari_qanday = 1;
                                        sendMessage.setChatId(update.getMessage().getChatId().toString());
                                        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
                                        replyKeyboardMarkup.setResizeKeyboard(true);
                                        replyKeyboardMarkup.setSelective(true);
                                        List<KeyboardRow> list_row = new ArrayList<>();
                                        KeyboardRow row1 = new KeyboardRow();
                                        KeyboardRow row2 = new KeyboardRow();
                                        KeyboardRow row3 = new KeyboardRow();
                                        KeyboardRow row4 = new KeyboardRow();
                                        KeyboardRow row5 = new KeyboardRow();
                                        KeyboardRow row6 = new KeyboardRow();
                                        KeyboardButton btn1 = new KeyboardButton();
                                        btn1.setText("Ismini kiritganlar");
                                        KeyboardButton btn6 = new KeyboardButton();
                                        btn6.setText("Start bosgan hamma");
                                        KeyboardButton btn2 = new KeyboardButton();
                                        btn2.setText("Tuzilgan testlar");
                                        KeyboardButton btn3 = new KeyboardButton();
                                        btn3.setText("Berilgan javoblar");
                                        KeyboardButton btn4 = new KeyboardButton();
                                        btn4.setText("Adminlar");
                                        KeyboardButton btn5 = new KeyboardButton();
                                        btn5.setText("∓Admin");

                                        row1.add(btn1);
                                        row2.add(btn2);
                                        row3.add(btn3);
                                        row4.add(btn4);
                                        row5.add(btn5);
                                        row6.add(btn6);
                                        list_row.add(row1);
                                        list_row.add(row6);
                                        list_row.add(row2);
                                        list_row.add(row3);
                                        list_row.add(row4);
                                        list_row.add(row5);
                                        replyKeyboardMarkup.setKeyboard(list_row);
                                        sendMessage.setReplyMarkup(replyKeyboardMarkup);
                                        sendMessage.setText(admins.get(i).getId());
                                        execute(sendMessage);
                                    } else if (xabar.equals("Start bosgan hamma")) {
                                        xabari_qanday = 1;

                                        String start = "";
                                        long t = 1;
                                        for (int j = 1; j < startbosganlar.size(); j++) {
                                            start += t + ". " + startbosganlar.get(j).getIsmi() + " " + startbosganlar.get(j).getId() + "\n";
                                            t++;
                                        }
                                        sendMessage.setText(start);
                                        execute(sendMessage);


                                    } else if (xabar.equals("Ismini kiritganlar")) {
                                        xabari_qanday = 1;

                                        String ismlarr = "";
                                        int t = 1;
                                        for (int j = 0; j < ismlar.size(); j++) {
                                            ismlarr += t + ". " + ismlar.get(j).getIsm_familiya() + " " + ismlar.get(j).getId() + "\n";
                                            t++;
                                        }
                                        sendMessage.setText(ismlarr);
                                        execute(sendMessage);
                                    } else if (xabar.equals("Tuzilgan testlar")) {
                                        xabari_qanday = 1;

                                        sendMessage.setText(tuzgan_savollar_arrayList.toString());
                                        execute(sendMessage);


                                    } else if (xabar.equals("Berilgan javoblar")) {
                                        xabari_qanday = 1;

                                        sendMessage.setText(berilgan_javoblar_arrayList.toString());
                                        execute(sendMessage);

                                    } else if (xabar.equals("Adminlar")) {
                                        xabari_qanday = 1;

                                        String Admin = "";
                                        int p = 1;
                                        for (int j = 0; j < admins.size(); j++) {
                                            Admin += p + ". " + admins.get(j).getId() + "\n";
                                            p++;
                                        }
                                        sendMessage.setText(Admin);
                                        execute(sendMessage);

                                    } else if (xabar.equals("∓Admin")) {
                                        xabari_qanday = 1;

                                        sendMessage.setText("+admin^id -> qo`shish\n" +
                                                "-admin^id -> chiqarib tashlash\n" +
                                                "(Foydalanuvchiga xabar yo`llash : \n" +
                                                "send/id/xabar)");
                                        execute(sendMessage);


                                    }
                                    String admin_sozi = "";

                                    if (String.valueOf(update.getMessage().getFrom().getId()).equals("804588100")) {
                                        for (int j = 0; j < xabar.length(); j++) {
                                            if (xabar.charAt(j) != '^') {
                                                admin_sozi += xabar.charAt(j);
                                            } else break;
                                        }
                                    }

                                    String id_admin = "";
                                    if (admin_sozi.equals("+admin")) {
                                        xabari_qanday = 1;
                                        for (int j = 7; j < xabar.length(); j++) {
                                            id_admin += xabar.charAt(j);
                                        }
                                        admins.add(new Admins(id_admin));
//                                        writer = new FileWriter("src/main/java/org/Ali/admins.txt");
//                                        for (int j = 0; j < admins.size(); j++) {
//                                            adminlar_string += admins.get(j).getId() + "\n";
//                                        }
//                                        writer.write(adminlar_string);
//                                        writer.close();
                                        sendMessage2.setChatId(id_admin);
                                        sendMessage2.setText("@Javob_tekshir_bot botiga @Sorry_no_this_username tomonidan adminlikka tayinlandinggiz!");
                                        sendMessage.setText("Adminlar safiga qo`shildi ✅\n" +
                                                "id = " + id_admin);
                                        execute(sendMessage);
                                        execute(sendMessage2);
                                    } else if (admin_sozi.equals("-admin")) {
                                        xabari_qanday = 1;
                                        for (int j = 7; j < xabar.length(); j++) {
                                            id_admin += xabar.charAt(j);
                                        }
                                        for (int j = 0; j < admins.size(); j++) {
                                            if (id_admin.equals(admins.get(j).getId())) {
                                                admins.remove(admins.get(j));
//                                                writer = new FileWriter("src/main/java/org/Ali/admins.txt");
//                                                for (int zxc = 0; zxc < admins.size(); zxc++) {
//                                                    adminlar_string += admins.get(zxc).getId() + "\n";
//                                                }
//                                                writer.write(adminlar_string);
//                                                writer.close();
                                                sendMessage2.setChatId(id_admin);
                                                sendMessage2.setText("@Javob_tekshir_bot botidan @Sorry_no_this_username tomonidan adminlikdan chiqarildinggiz!");
                                                sendMessage.setText("Ro`yxatdan chiqarildi \n" +
                                                        "id = " + id_admin);
                                                execute(sendMessage);
                                                execute(sendMessage2);
                                            }
                                        }
                                    }
                                    int daraja = 0;
                                    for (int j = 0; j < xabar.length(); j++) {
                                        if (xabar.charAt(j) == '/') {
                                            daraja++;
                                        }
                                    }
                                    String[] tyu;
                                    if (daraja == 2) {
                                        tyu = xabar.split("/");
                                        if (tyu[0].equals("send")) {
                                            xabari_qanday = 1;
                                            sendMessage.setChatId(tyu[1]);
                                            sendMessage.setText(tyu[2]);
                                            execute(sendMessage);
                                            sendMessage2.setChatId(update.getMessage().getChatId().toString());
                                            sendMessage2.setText("Yetkazildi!");
                                            execute(sendMessage2);
                                        }
                                    }
                                }
                            }

                            if (ismi_bor != ismlar.size()) {

                                if (xabar.equals("/malumot")) {
                                    xabari_qanday = 1;
                                    String ismi = "";
                                    for (int i = 0; i < ismlar.size(); i++) {
                                        if (update.getMessage().getFrom().getId().toString().equals(ismlar.get(i).getId())) {
                                            ismi = ismlar.get(i).getIsm_familiya();
                                        }
                                    }
                                    sendMessage.setText("\uD83D\uDC64 Sizning ism familiyangiz : \n  " + ismi +
                                            "\n\uD83D\uDD04 Ism familiyangizni o`zgartirishni istasangiz : \n" +
                                            "   If*Ism familiya " +
                                            "\nko`rinishida xabar yuboring.");

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
                                    if (xabar.charAt(i) == '*') {
                                        pluslar_soni++;
                                    }
                                }

// ---------------------------------------betaraf hudud quyisi----------------------------------------------


                                // ----------------------------Test tuzish----------------------------------------------------------


                                if (test_tuzish_kaliti.equals("Test") || test_tuzish_kaliti.equals("test")) {
                                    xabari_qanday = 1;
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

                                            Tuzgan_savollar tuzgan_savollar = new Tuzgan_savollar(String.valueOf(test_kodi),
                                                    Fan_nomi, ornatilgan_javob, ornatilgan_javoblar_soni, update.getMessage().getFrom().getId().toString(),
                                                    update.getMessage().getFrom().getUserName());
                                            tuzgan_savollar_arrayList.add(tuzgan_savollar);
//                                            try {
//                                                writer = new FileWriter("src/main/java/org/Ali/tuzilgan_savollar.txt");
//                                                for (int qwewq = 0; qwewq < tuzgan_savollar_arrayList.size(); qwewq++) {
//                                                    tuzilgan_savollar_string += tuzgan_savollar_arrayList.get(qwewq).getKodi() + "~" +
//                                                            tuzgan_savollar_arrayList.get(qwewq).getFan_nomi() + "~" +
//                                                            tuzgan_savollar_arrayList.get(qwewq).getHaqiqiy_javob() + "~" +
//                                                            String.valueOf(tuzgan_savollar_arrayList.get(qwewq).getHaqiqiy_javoblar_soni()) + "~" +
//                                                            tuzgan_savollar_arrayList.get(qwewq).getId() + "~" + tuzgan_savollar_arrayList.get(qwewq).getUsername() + "\n";
//                                                }
//                                                writer.write(tuzilgan_savollar_string);
//                                                writer.close();
//                                            } catch (IOException e) {
//                                                e.printStackTrace();
//                                            }


                                            test_kodi++;

                                            if (test_kodi == 100000) {
                                                test_kodi = 100;
                                                for (int i = 0; i < tuzgan_savollar_arrayList.size(); i++) {
                                                    if (Integer.parseInt(tuzgan_savollar_arrayList.get(i).getKodi()) < 50000 && Integer.parseInt(tuzgan_savollar_arrayList.get(i).getKodi()) > 99) {
                                                        tuzgan_savollar_arrayList.remove(tuzgan_savollar_arrayList.get(i));
                                                    }
                                                }
                                                for (int i = 0; i < berilgan_javoblar_arrayList.size(); i++) {
                                                    if (Integer.parseInt(berilgan_javoblar_arrayList.get(i).getTest_kodi()) < 50000 && Integer.parseInt(berilgan_javoblar_arrayList.get(i).getTest_kodi()) > 99) {
                                                        berilgan_javoblar_arrayList.remove(berilgan_javoblar_arrayList.get(i));
                                                    }
                                                }
                                            }

                                            if (test_kodi == 50000) {
                                                for (int i = 0; i < tuzgan_savollar_arrayList.size(); i++) {
                                                    if (Integer.parseInt(tuzgan_savollar_arrayList.get(i).getKodi()) >= 50000 && Integer.parseInt(tuzgan_savollar_arrayList.get(i).getKodi()) < 100000) {
                                                        tuzgan_savollar_arrayList.remove(tuzgan_savollar_arrayList.get(i));
                                                    }
                                                }
                                                for (int i = 0; i < berilgan_javoblar_arrayList.size(); i++) {
                                                    if (Integer.parseInt(berilgan_javoblar_arrayList.get(i).getTest_kodi()) >= 50000 && Integer.parseInt(berilgan_javoblar_arrayList.get(i).getTest_kodi()) < 100000) {
                                                        berilgan_javoblar_arrayList.remove(berilgan_javoblar_arrayList.get(i));
                                                    }
                                                }
                                            }

//                                            writer = new FileWriter("src/main/java/org/Ali/test_kodi.txt");
//                                            writer.write(String.valueOf(test_kodi));
//                                            writer.close();


                                            sendMessage.setChatId(update.getMessage().getChatId().toString());
                                            sendMessage2.setChatId(update.getMessage().getChatId().toString());
                                            sendMessage2.setText("Testlar kaliti muvaffaqqiyatli qo`shildi✅\n");
                                            sendMessage.setText("\uD83D\uDD22 Test kodi : " + tuzgan_savollar.getKodi() + "\nSavollar soni : " +
                                                    ornatilgan_javoblar_soni + " ta\n" +
                                                    "❗️ Javoblarni\n" +
                                                    "   testkodi*test javoblari\n" +
                                                    "ko`rinishida ❗️\n\n" +
                                                    "@Javob_tekshir_bot  ga\n\n" +
                                                    "yuborishingiz mumkin.\n" +
                                                    "Barchaga omad \uD83E\uDD1D ");
                                            execute(sendMessage2);
                                            execute(sendMessage);
                                        } else {
                                            sendMessage.setText("Fan nomi yoki savollar bo`sh bo`lishi mumkin emas!!!");
                                            execute(sendMessage);

                                        }
                                    } else {
                                        sendMessage.setText("Yulduzchalarga e`tibor bering\nNamunadagidek kiriting : \nTest*Matematika*abcdabcd...");
                                        execute(sendMessage);
                                    }
                                }

                                //------------------------------test tuzish tugadi ---------------------------------------------------------


                                //-----------------------------javob berish -----------------------------------------------------------


                                if (pluslar_soni == 1) {
                                    xabari_qanday = 1;
                                    Berilgan_javoblar berilgan_javoblar;
                                    String foydalanuvchi_yozgan_kodi = "";
                                    for (int i = 0; i < xabar.length(); i++) {
                                        if (xabar.charAt(i) != '*') {
                                            foydalanuvchi_yozgan_kodi += xabar.charAt(i);
                                        } else break;
                                    }


                                    String foydalanuvchi_bergan_javobi = "";
                                    int foydalanuvchi_bergan_javoblar_soni = 0;
                                    for (int i = 1 + foydalanuvchi_yozgan_kodi.length(); i < xabar.length(); i++) {
                                        foydalanuvchi_bergan_javobi += xabar.charAt(i);
                                        foydalanuvchi_bergan_javoblar_soni++;
                                    }

                                    int toplagan_bali = 0;
                                    int javob_bergan = 0;
                                    for (int i = 0; i < berilgan_javoblar_arrayList.size(); i++) {
                                        if (berilgan_javoblar_arrayList.get(i).getId().equals(String.valueOf(update.getMessage().getFrom().getId()))) {
                                            if (!berilgan_javoblar_arrayList.get(i).getTest_kodi().equals(foydalanuvchi_yozgan_kodi)) {
                                                javob_bergan++;
                                            }
                                        } else {
                                            javob_bergan++;
                                        }
                                    }
                                    if (javob_bergan == berilgan_javoblar_arrayList.size()) {
                                        int k = 0;
                                        int p = 0;
                                        for (int i = 0; i < tuzgan_savollar_arrayList.size(); i++) {
                                            if (foydalanuvchi_yozgan_kodi.equals(tuzgan_savollar_arrayList.get(i).getKodi())) {
                                                k++;
                                                if (foydalanuvchi_bergan_javoblar_soni == tuzgan_savollar_arrayList.get(i).getHaqiqiy_javoblar_soni()) {
                                                    p++;
                                                    String ismi = "";
                                                    for (int j = 0; j < ismlar.size(); j++) {
                                                        if (update.getMessage().getFrom().getId().toString().equals(ismlar.get(j).getId())) {
                                                            ismi = ismlar.get(j).getIsm_familiya();
                                                        }
                                                    }
                                                    String xato_javoblari = "";
                                                    String xato_javoblari2 = "";
                                                    for (int j = 0; j < foydalanuvchi_bergan_javobi.length(); j++) {
                                                        if (tuzgan_savollar_arrayList.get(i).getHaqiqiy_javob().charAt(j) == foydalanuvchi_bergan_javobi.charAt(j)) {
                                                            toplagan_bali++;
                                                        } else {
                                                            xato_javoblari += (j + 1) + ", ";
                                                        }
                                                    }
                                                    if (xato_javoblari != "") {
                                                        for (int j = 0; j < xato_javoblari.length() - 2; j++) {
                                                            xato_javoblari2 += xato_javoblari.charAt(j);
                                                        }
                                                    }
                                                    if (xato_javoblari2 == "") {
                                                        xato_javoblari2 = "0";
                                                    }


                                                    berilgan_javoblar = new Berilgan_javoblar(foydalanuvchi_yozgan_kodi,
                                                            ismi, toplagan_bali, update.getMessage().getFrom().getUserName(),
                                                            String.valueOf(update.getMessage().getFrom().getId()), xato_javoblari2);

                                                    berilgan_javoblar_arrayList.add(berilgan_javoblar);

//                                                    writer = new FileWriter("src/main/java/org/Ali/berilgan_javoblar.txt");
//                                                    for (int qwer = 0; qwer < berilgan_javoblar_arrayList.size(); qwer++) {
//                                                        berilgan_javoblar_string += berilgan_javoblar_arrayList.get(qwer).getTest_kodi() + "~" +
//                                                                berilgan_javoblar_arrayList.get(qwer).getIsmi() + "~" +
//                                                                String.valueOf(berilgan_javoblar_arrayList.get(qwer).getToplagan_bali()) + "~" +
//                                                                berilgan_javoblar_arrayList.get(qwer).getUsername() + "~" +
//                                                                berilgan_javoblar_arrayList.get(qwer).getId() + "~" + berilgan_javoblar_arrayList.get(qwer).getXato_javoblari() + "\n";
//                                                    }
//                                                    writer.write(berilgan_javoblar_string);
//                                                    writer.close();


                                                    sendMessage.setChatId(update.getMessage().getChatId().toString());
                                                    sendMessage.setText("\uD83D\uDD22 Test kodi : " + foydalanuvchi_yozgan_kodi +
                                                            "\nFan nomi : " + tuzgan_savollar_arrayList.get(i).getFan_nomi() +
                                                            "\nSavollar soni : " + foydalanuvchi_bergan_javoblar_soni + " ta" +
                                                            "\n✅To`g`ri javoblar soni : " + toplagan_bali + " ta\n" +
                                                            "❌Noto`g`ri javoblar soni : " + (foydalanuvchi_bergan_javoblar_soni - toplagan_bali) + " ta");


                                                    execute(sendMessage);

                                                    sendMessage_test_egasi1.setChatId(tuzgan_savollar_arrayList.get(i).getId());
                                                    sendMessage_test_egasi1.setText("\uD83D\uDD22 Test kodi : " + berilgan_javoblar.getTest_kodi() + "\n" +
                                                            berilgan_javoblar.getIsmi() + "(@" + update.getMessage().getFrom().getUserName() + ") javob berdi.\n");

                                                    InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
                                                    List<List<InlineKeyboardButton>> katta_list = new ArrayList<>();
                                                    List<InlineKeyboardButton> kichik_list = new ArrayList<>();
                                                    InlineKeyboardButton inlineKeyboardButton1 = new InlineKeyboardButton();
                                                    inlineKeyboardButton1.setText("Ko`rish");
                                                    inlineKeyboardButton1.setCallbackData("Jadval!" + berilgan_javoblar.getTest_kodi());
                                                    InlineKeyboardButton inlineKeyboardButton2 = new InlineKeyboardButton();
                                                    inlineKeyboardButton2.setText("Tugatish");
                                                    inlineKeyboardButton2.setCallbackData("Tugasin!" + berilgan_javoblar.getTest_kodi());
                                                    kichik_list.add(inlineKeyboardButton1);
                                                    kichik_list.add(inlineKeyboardButton2);
                                                    katta_list.add(kichik_list);
                                                    inlineKeyboardMarkup.setKeyboard(katta_list);
                                                    sendMessage_test_egasi1.setReplyMarkup(inlineKeyboardMarkup);
                                                    execute(sendMessage_test_egasi1);


                                                }
                                            }
                                        }
                                        if (k == 0) {
                                            if (Integer.parseInt(foydalanuvchi_yozgan_kodi) >= test_kodi) {
                                                sendMessage.setText("Bunday kodli test tuzilmagan!!!");
                                                execute(sendMessage);
                                            } else if (Integer.parseInt(foydalanuvchi_yozgan_kodi) < test_kodi && Integer.parseInt(foydalanuvchi_yozgan_kodi) > 99) {
                                                sendMessage.setText("Bu test allaqachon yakunlanib bo`lingan!!!");
                                                execute(sendMessage);
                                            }
                                        }
                                        if (k != 0 && p == 0) {
                                            for (int i = 0; i < tuzgan_savollar_arrayList.size(); i++) {
                                                if (tuzgan_savollar_arrayList.get(i).getKodi().equals(foydalanuvchi_yozgan_kodi)) {
                                                    sendMessage.setText(foydalanuvchi_yozgan_kodi + " - kodli testning savollar soni " + tuzgan_savollar_arrayList.get(i).getHaqiqiy_javoblar_soni() +
                                                            " ta, lekin siz " + foydalanuvchi_bergan_javoblar_soni + " ta javob yozdingiz ❌");
                                                    execute(sendMessage);
                                                }
                                            }
                                        }
                                    } else {
                                        sendMessage.setText("Siz " + foydalanuvchi_yozgan_kodi + " - kodli testga javob berib bo`lgansiz");
                                        execute(sendMessage);
                                    }
                                }

                                // ---------------------------------Javob berish tugadi------------------------------------------------
                                if (xabari_qanday == 0) {
                                    sendMessage.setText("Botdan qanday foydalanishni ko`rib chiqing ‼️");
                                    execute(sendMessage);
                                }

                            } else if (!xabar.equals("/start") && !xabar.equals("/help")) {
                                sendMessage.setText("Botdan foydalanishingiz uchun ism familiyangizni namunadagidek kiriting : \n" +
                                        "Namuna : If*Ism familiya");
                                sendMessage.setParseMode(ParseMode.HTML);
                                execute(sendMessage);
                            }
                        } else {
                            sendMessage.setChatId(update.getMessage().getChatId().toString());
                            sendMessage.setParseMode(ParseMode.HTML);
                            sendMessage.setText("Botdan qanday foydalanishni ko`rib chiqing ‼️");
                            execute(sendMessage);
                        }
                    } else {
                        sendMessage.setChatId(update.getMessage().getChatId().toString());
                        sendMessage.setParseMode(ParseMode.HTML);
                        sendMessage.setText("'~' belgidan foydalanmang");
                        execute(sendMessage);
                    }
                }
            } else if (update.hasCallbackQuery()) {
                CallbackQuery callbackQuery = update.getCallbackQuery();
                String id = callbackQuery.getId();
                String chat_id = callbackQuery.getMessage().getChatId().toString();
                sendMessage_call_back.setChatId(chat_id);
                answer_call.setCallbackQueryId(id);
                String data = callbackQuery.getData();
                String[] a = data.split("!");
                boolean exx = false;
                for (int i = 0; i < tuzgan_savollar_arrayList.size(); i++) {
                    if (tuzgan_savollar_arrayList.get(i).getKodi().equals(a[1])) {
                        exx = true;
                    }
                }
                if (exx) {

                    //------------------------------------------Jadval chiqarish -------------------------------------------
                    if (a[0].equals("Jadval")) {
                        String jadval = "";
                        int q = 1;
                        jadval += "\uD83D\uDD22 Test kodi : " + a[1] + "\n";
                        for (int i = 0; i < berilgan_javoblar_arrayList.size(); i++) {
                            if (a[1].equals(String.valueOf(berilgan_javoblar_arrayList.get(i).getTest_kodi()))) {
                                jadval += q + "." + berilgan_javoblar_arrayList.get(i).getIsmi() + " " + berilgan_javoblar_arrayList.get(i).getToplagan_bali()
                                        + " ta\n";
                                q++;
                            }
                        }
                        answer_call.setText("");
                        execute(answer_call);
                        sendMessage_call_back.setText(jadval);
                        execute(sendMessage_call_back);

                        //------------------------------------------Testni tugatish-------------------------------------------
                    } else if (a[0].equals("Tugasin")) {

                        ArrayList<Berilgan_javoblar> ishtirokchilar = new ArrayList<>();

                        String Fan_nomi = "";
                        int javoblar_soni = 0;
                        String javoblar = "";
                        for (int i = 0; i < tuzgan_savollar_arrayList.size(); i++) {
                            if (tuzgan_savollar_arrayList.get(i).getKodi().equals(a[1])) {
                                Fan_nomi = tuzgan_savollar_arrayList.get(i).getFan_nomi();
                                javoblar_soni = tuzgan_savollar_arrayList.get(i).getHaqiqiy_javoblar_soni();
                                javoblar = tuzgan_savollar_arrayList.get(i).getHaqiqiy_javob();
                            }
                        }


                        long p = 1;
                        String ragbat;
                        String yakuniy_jadval = "";
                        yakuniy_jadval += "\uD83D\uDD22 Test kodi : " + a[1] +
                                "\n\nFan nomi : " + Fan_nomi + "\n\n";

                        for (int i = 0; i < berilgan_javoblar_arrayList.size(); i++) {
                            if (a[1].equals(berilgan_javoblar_arrayList.get(i).getTest_kodi())) {
                                ishtirokchilar.add(berilgan_javoblar_arrayList.get(i));
                            }
                        }
                        int[] ballar = new int[ishtirokchilar.size()];
                        for (int i = 0; i < ishtirokchilar.size(); i++) {
                            if (i != 0) {
                                boolean son_takrorlan = true;
                                for (int j = 0; j < i; j++) {
                                    if (ishtirokchilar.get(i).getToplagan_bali() != ballar[j]) {
                                        son_takrorlan &= true;
                                    } else {
                                        son_takrorlan = false;
                                    }
                                }
                                if (son_takrorlan) {
                                    ballar[i] = ishtirokchilar.get(i).getToplagan_bali();
                                } else {
                                    ballar[i] = -1;
                                }
                            } else {
                                ballar[i] = ishtirokchilar.get(i).getToplagan_bali();
                            }
                        }
                        for (int i = 1; i < ballar.length; i++) {
                            for (int j = 0; j < ballar.length - i; j++) {
                                if (ballar[j] < ballar[j + 1]) {
                                    int temp = ballar[j];
                                    ballar[j] = ballar[j + 1];
                                    ballar[j + 1] = temp;
                                }
                            }
                        }
                        for (int i = 0; i < ballar.length; i++) {
                            for (int j = 0; j < ishtirokchilar.size(); j++) {
                                if (ishtirokchilar.get(j).getToplagan_bali() == ballar[i]) {
                                    if (p == 1) {
                                        ragbat = "\uD83E\uDD47";
                                    } else if (p == 2) {
                                        ragbat = "\uD83E\uDD48";
                                    } else if (p == 3) {
                                        ragbat = "\uD83E\uDD49";
                                    } else {
                                        ragbat = "";
                                    }
                                    if (ishtirokchilar.get(j).getToplagan_bali() == javoblar_soni && p != 1 && p != 2 && p != 3) {
                                        ragbat = "\uD83C\uDFC5";
                                    }
                                    yakuniy_jadval += p + "." + ishtirokchilar.get(j).getIsmi() + " " + ballar[i] + " " + ragbat + "\n";
                                    p++;
                                }
                            }
                        }
                        String javoblar_jadvali = "";
                        int q = 1;
                        for (int i = 0; i < javoblar.length(); i++) {
                            if (q % 4 == 0) {
                                javoblar_jadvali += q + "." + javoblar.charAt(i) + "\n";
                                q++;
                            } else {
                                javoblar_jadvali += q + "." + javoblar.charAt(i) + "    ";
                                q++;
                            }
                        }
                        yakuniy_jadval += "\n\nTo`g`ri javoblar : \n\n" + javoblar_jadvali;

                        yakuniy_jadval += "\n\nTestda qatnashgan barchaga rahmat! \uD83D\uDE0A";

                        for (int i = 0; i < tuzgan_savollar_arrayList.size(); i++) {
                            if (tuzgan_savollar_arrayList.get(i).getKodi().equals(a[1])) {
                                tuzgan_savollar_arrayList.remove(tuzgan_savollar_arrayList.get(i));
                                break;
                            }
                        }

                        for (int i = 0; i < berilgan_javoblar_arrayList.size(); i++) {
                            if (berilgan_javoblar_arrayList.get(i).getTest_kodi().equals(a[1])) {
                                sendMessage.setChatId(berilgan_javoblar_arrayList.get(i).getId());
                                if (berilgan_javoblar_arrayList.get(i).getXato_javoblari() == "0") {
                                    sendMessage.setText(berilgan_javoblar_arrayList.get(i).getTest_kodi() +
                                            " - kodli testda xatolaringiz yo`q");
                                } else {
                                    String xatolar = berilgan_javoblar_arrayList.get(i).getTest_kodi() +
                                            " - kodli testdagi xatolaringiz : \n" + berilgan_javoblar_arrayList.get(i).getXato_javoblari();
                                    sendMessage.setText(xatolar);
                                }
                                execute(sendMessage);
                                berilgan_javoblar_arrayList.remove(berilgan_javoblar_arrayList.get(i));
                                i--;
                            }
                        }

//                        try {
//                            writer = new FileWriter("src/main/java/org/Ali/tuzilgan_savollar.txt");
//                            for (int qwewq = 0; qwewq < tuzgan_savollar_arrayList.size(); qwewq++) {
//                                tuzilgan_savollar_string += tuzgan_savollar_arrayList.get(qwewq).getKodi() + "~" +
//                                        tuzgan_savollar_arrayList.get(qwewq).getFan_nomi() + "~" +
//                                        tuzgan_savollar_arrayList.get(qwewq).getHaqiqiy_javob() + "~" +
//                                        String.valueOf(tuzgan_savollar_arrayList.get(qwewq).getHaqiqiy_javoblar_soni()) + "~" +
//                                        tuzgan_savollar_arrayList.get(qwewq).getId() + "~" + tuzgan_savollar_arrayList.get(qwewq).getUsername() + "\n";
//                            }
//                            writer.write(tuzilgan_savollar_string);
//                            writer.close();
//                        } catch (IOException e) {
//                            e.printStackTrace();
//                        }
//
//                        writer = new FileWriter("src/main/java/org/Ali/berilgan_javoblar.txt");
//                        for (int qwer = 0; qwer < berilgan_javoblar_arrayList.size(); qwer++) {
//                            berilgan_javoblar_string += berilgan_javoblar_arrayList.get(qwer).getTest_kodi() + "~" +
//                                    berilgan_javoblar_arrayList.get(qwer).getIsmi() + "~" +
//                                    String.valueOf(berilgan_javoblar_arrayList.get(qwer).getToplagan_bali()) + "~" +
//                                    berilgan_javoblar_arrayList.get(qwer).getUsername() + "~" +
//                                    berilgan_javoblar_arrayList.get(qwer).getId() + "~" + berilgan_javoblar_arrayList.get(qwer).getXato_javoblari() + "\n";
//                        }
//                        writer.write(berilgan_javoblar_string);
//                        writer.close();

                        sendMessage_call_back.setText(yakuniy_jadval);

                        answer_call.setText(a[1] + " - kodli test yakunlandi ✅");
                        execute(sendMessage_call_back);
                        execute(answer_call);
                    }
                } else {
                    sendMessage_call_back.setText("Bu test allaqachon yakunlanib bo`lingan ⁉️");
                    answer_call.setText("");
                    execute(sendMessage_call_back);
                    execute(answer_call);
                }
            }
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }
}