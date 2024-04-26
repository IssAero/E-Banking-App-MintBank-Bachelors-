package com.licentaebank.helpers;

public class HTML {

    public static String htmlEmailTemplate(String token, int code) {

        //verify Account URL:
        String url = "http://127.0.0.1:8070/verify?token=" + token + "&code=" + code;

        String emailTemplate = "<!DOCTYPE html>\n" +
                "<html lang='en'>\n" +
                "  <head>\n" +
                "    <meta charset='UTF-8'>\n" +
                "    <meta name='viewport' content='width=device-width, initial-scale=1.0'>\n" +
                "    <meta http-equiv='X-UA-Compatible' content='ie=edge'>\n" +
                "    <link rel='stylesheet' href='css/email.css'>\n" +
                "    <title>Email</title>\n" +
                "    <style>\n" +
                "        *{\n" +
                "    box-sizing: border-box;\n" +
                "    font-family: Helmet Neue;\n" +
                "    }\n" +
                "\n" +
                "    /* Main Body Styling */\n" +
                "    body{\n" +
                "        height: 100vh;\n" +
                "        background-color: rgb(37, 37, 37);\n" +
                "        display: flex;\n" +
                "        align-items: center;\n" +
                "        justify-content: center;\n" +
                "    }\n" +
                "\n" +
                "    /* <!-- Wrapper --> */\n" +
                "    .wrapper{\n" +
                "        width: 550px;\n" +
                "        height: auto;\n" +
                "        padding: 15px;\n" +
                "        background-color: #f5f5f5;\n" +
                "        border-radius: 7px;\n" +
                "    }\n" +
                "\n" +
                "    /* Email MSG Header*/\n" +
                "    .email-msg-header{\n" +
                "        text-align: center;\n" +
                "        color: black;\n" +
                "    }\n" +
                "\n" +
                "    .company-name h2{\n" +
                "        font-weight: bold;\n" +
                "        font-family: Bebas Neue;\n" +
                "        text-align: center;\n" +
                "        font-size: 40px;\n" +
                "        margin: 15px 0px;\n" +
                "        color: black;\n" +
                "    }\n" +
                "\n" +
                "    /* <!-- Welcome Text --> */\n" +
                "    .welcome-text{\n" +
                "        text-align: center;\n" +
                "        color: black;\n" +
                "    }\n" +
                "\n" +
                "    /* <!-- Verify Account Button --> */\n" +
                "    .verify-account-btn{\n" +
                "        margin-bottom: 10px;\n" +
                "        padding: 15px;\n" +
                "        background-color: #00FFAB;\n" +
                "        text-decoration: none;\n" +
                "        color: black;\n" +
                "        border-radius: 5px;\n" +
                "        box-shadow: 0px 1px 2px black\n" +
                "    }\n" +
                "\n" +
                "    /* <!-- Copy Right Wrapper --> */\n" +
                "    .copy-right{\n" +
                "        margin-top: 25px;\n" +
                "        font-size: 14px;\n" +
                "        color: black;\n" +
                "        padding: 15px;\n" +
                "        display: flex;\n" +
                "        align-items: center;\n" +
                "        justify-content: center;\n" +
                "    }\n" +
                "\n" +
                "    </style>\n" +
                "  </head>\n" +
                "  <body>\n" +
                "\n" +
                "    <!-- Wrapper -->\n" +
                "    <div class='wrapper'>\n" +
                "        <!-- Email MSG Header -->\n" +
                "        <h2 class='email-msg-header'>\n" +
                "            Bine ai venit! Multumim ca ai ales\n" +
                "        </h2>\n" +
                "        <!-- End Email MSG Header -->\n" +
                "\n" +
                "        <!-- Company Name -->\n" +
                "        <div class='company-name'>\n" +
                "            <h2>Evermint Bank</h2>\n" +
                "        </div>\n" +
                "        <!-- End Company Name-->\n" +
                "\n" +
                "        <hr style='background:transparent; border:0; height:2px' />\n" +
                "\n" +
                "        <!-- Welcome Text -->\n" +
                "        <p class='welcome-text'>\n" +
                "            Contul a fost inregistrat cu success. Apasa mai jos pentru a confirma e-mailul.\n" +
                "        </p>\n" +
                "        <!-- End Welcome Text -->\n" +
                "        <br>\n" +
                "        <br>\n" +
                "        <!-- Verify Account Button -->\n" +
                "        <center><a href='"+ url +"' class='verify-account-btn' role='button'>Confirma</a></center>\n" +
                "        <!-- End Verify Account Button -->\n" +
                "\n" +
                "        <!-- Copy Right Wrapper -->\n" +
                "        <div class='copy-right'>\n" +
                "            &copy; Copy Right 2024. All Rights Reserved.\n" +
                "        </div>\n" +
                "        <!-- End Copy Right Wrapper -->\n" +
                "\n" +
                "    </div>\n" +
                "    <!-- End Wrapper -->\n" +
                "\n" +
                "\n" +
                "  </body>\n" +
                "</html>";
        return emailTemplate;
    }
}
