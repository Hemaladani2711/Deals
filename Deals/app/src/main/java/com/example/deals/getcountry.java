package com.example.deals;

import android.util.Log;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Hemal on 12/13/2015.
 */
public class getcountry {


    String []countrynames;
    public String[] getCountrydetail()
    {

        countrynames=new String[]{"Afghanistan","Albania","Algeria","American Samoa","Andorra","Angola","Anguilla","Antarctica","Antigua","Argentina","Armenia","Aruba","Ascension","Australia","Austria","Azerbaijan","Bahamas","Bahrain","Bangladesh","Barbados","Barbuda","Belarus","Belgium","Belize","Benin","Bermuda","Bhutan","Bolivia","Bosnia & Herzegovina","Botswana","Brazil","British Virgin Islands","Brunei Darussalam","Bulgaria","Burkina Faso","Burundi","Cambodia","Cameroon","Canada","Cape Verde Islands","Cayman Islands","Central African Republic","Chad","Chatham Island -New Zealand","Chile","China","Christmas Island","Cocos - Keeling Islands","Colombia","Comoros","Congo","Cook Islands","Costa Rica","Croatia","Cuba","Cyprus","Czech Republic","Denmark","Diego Garcia","Djibouti","Dominica","East Timor","Easter Island","Ecuador ","Egypt","El Salvador","Equatorial Guinea","Eritrea","Estonia","Ethiopia","Falkland Islands-Malvinas","Faroe Islands","Fiji Islands","Finland","France","French Antilles","French Guiana","French Polynesia","Gabonese Republic","Gambia","Georgia","Germany","Ghana ","Gibraltar ","Greece ","Greenland ","Grenada","Guadeloupe","Guam","Guantanamo Bay","Guatemala ","Guinea-Bissau ","Guinea","Guyana","Haiti ","Honduras","Hong Kong","Hungary ","Iceland","India","Indonesia","Iran","Iraq","Ireland","Israel ","Italy ","Jamaica ","Japan ","Jordan","Kazakhstan","Kenya","Kiribati ","Korea-North","Korea-South","Kuwait ","Kyrgyz Republic","Laos","Latvia ","Lebanon","Lesotho","Liberia","Libya","Liechtenstein","Lithuania ","Luxembourg","Macao","Macedonia","Madagascar","Malawi ","Malaysia","Maldives","Mali Republic","Malta","Marshall Islands","Martinique","Mauritania","Mauritius","Mayotte Island","Mexico","Micronesia","Midway Island","Moldova ","Monaco","Mongolia ","Montenegro","Montserrat ","Morocco","Mozambique","Myanmar","Namibia","Nauru","Nepal ","Netherlands","Nevis","New Caledonia","New Zealand","Nicaragua","Niger","Nigeria","Niue","Norfolk Island","Northern Marianas Islands ","Norway ","Oman","Pakistan","Palau","Palestinian Settlements","Panama","Papua New Guinea","Paraguay","Peru","Philippines","Poland","Portugal","Qatar","Romania","Russia","Rwandese Republic","St. Helena","St. Kitts Nevis","St. Lucia","St. Pierre & Miquelon","St. Vincent & Grenadines","Samoa","San Marino","Saudi Arabia","Senegal ","Serbia","Seychelles Republic","Sierra Leone","Singapore","Slovak Republic","Slovenia ","Solomon Islands","Somali Democratic Republic","South Africa","Spain","Sri Lanka","Sudan","Suriname ","Swaziland","Sweden","Switzerland","Syria","Taiwan","Tajikistan","Tanzania","Thailand","Timor Leste","Togolese Republic","Tokelau ","Tonga Islands","Trinidad & Tobago","Tunisia","Turkey","Turkmenistan ","Turks and Caicos Islands","Tuvalu","Uganda","Ukraine","United Arab Emirates","United Kingdom","United States of America","US Virgin Islands","Uruguay","Uzbekistan","Vanuatu","Venezuela","Vietnam","Wake Island","Wallis and Futuna Islands","Yemen","Zambia ","Zanzibar","Zimbabwe "};

        return countrynames;
    }

    public String getCountryCode(String strCountryname)
    {
        int i,no=0;
        //Log.i("Country Name",strCountryname);
            for(i=0;i<countrynames.length;i++)
            {
                if(countrynames[i].equals(strCountryname))
                {
                    no=i;
                    break;
                }
            }
            //Log.i("Number",""+i);
            ArrayList<String> countrycodes=new ArrayList<String>(Arrays.asList("+93","+355","+213",	"+1-684",	"+376",	"+244",	"+1-264",	"+672",	"+1-268",	"+54",	"+374",	"+297",	"+247",	"+61",	"+43",	"+994",	"+1-242",	"+973",	"+880",	"+1-246"	,"+1-268"	,"+375",	"+32",	"+501",	"+229",	"+1-441",	"+975",	"+591",	"+387",	"+267",	"+55",	"+1-284",	"+673",	"+359",	"+226",	"+257",	"+855",	"+237",	"+1",	"+238",	"+1-345",	"+236",	"+235",	"+64",	"+56",	"+86",	"+61-8",	"+61",	"+57",	"+269",	"+242",	"+682",	"+506","+385",	"+53","+357",	"+420",	"+45",	"+246",	"+253",	"+1-767",	"+670",	"+56",	"+593",	"+20",	"+503",	"+240",	"+291",	"+372",	"+251",	"+500",	"+298",	"+679",	"+358",	"+33",	"+596",	"+594",	"+689",	"+241",	"+220",	"+995",	"+49",	"+233",	"+350",	"+30",	"+299",	"+1-473",	"+590",	"+1-671",	"+5399",	"+502",	"+245",	"+224",	"+592",	"+509",	"+504",	"+852",	"+36",	"+354",	"+91",	"+62","+98",	"+964",	"+353",	"+972",	"+39",	"+1-876",	"+81",	"+962",	"+7",	"+254",	"+686",	"+850",	"+82",	"+965",	"+996",	"+856",	"+371",	"+961",	"+266",	"+231",	"+218",	"+423",	"+370",	"+352",	"+853",	"+389",	"+261",	"+265",	"+60",	"+960",	"+223",	"+356",	"+692",	"+596",	"+222",	"+230",	"+269",	"+52",	"+691",	"+1-808",	"+373",	"+377",	"+976",	"+382",	"+1-664",	"+212",	"+258",	"+95",	"+264",	"+674",	"+977",	"+31",	"+1-869",	"+687",	"+64",	"+505",	"+227",	"+234",	"+683",	"+672",	"+1-670",	"+47",	"+968",	"+92",	"+680",	"+970",	"+507",	"+675",	"+595",	"+51",	"+63",	"+48",	"+351",	"+974","+40","+7",	"+250",	"+290",	"+1-869",	"+1-758",	"+508",	"+1-784",	"+685",	"+378","+966",	"+221",	"+381",	"+248",	"+232",	"+65",	"+421",	"+386",	"+677",	"+252",	"+27",	"+34",	"+94",	"+249",	"+597",	"+268",	"+46",	"+41",	"+963",	"+886",	"+992",	"+255",	"+66",	"+670",	"+228",	"+690",	"+676",	"+1-868",	"+216",	"+90",	"+993",	"+1-649",	"+688",	"+256",	"+380",	"+971",	"+44",	"+1",	"+1-340",	"+598",	"+998",	"+678",	"+58",	"+84","+808","+681",	"+967",	"+260",	"+255",	"+263"));
            //Log.i("Country names length",""+countrynames.length);
            //Log.i("Codes length",""+countrycodes.size());

            return countrycodes.get(no);


    }

}
