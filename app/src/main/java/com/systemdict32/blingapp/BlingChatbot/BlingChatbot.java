package com.systemdict32.blingapp.BlingChatbot;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Handler;
import android.speech.RecognizerIntent;
import android.speech.tts.TextToSpeech;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentTransaction;

import com.systemdict32.blingapp.Fragments.Categories.c10_1_CprFragment;
import com.systemdict32.blingapp.Fragments.Categories.c10_2_VitalSignsFragment;
import com.systemdict32.blingapp.Fragments.Categories.c10_3_ChokingsFragment;
import com.systemdict32.blingapp.Fragments.Categories.c10_4_BandagesFragment;
import com.systemdict32.blingapp.Fragments.Categories.c10_FirstAidBasicFragment;
import com.systemdict32.blingapp.Fragments.Categories.c1_EmergencyBasicFragment;
import com.systemdict32.blingapp.Fragments.Categories.c2_WoundsFragment;
import com.systemdict32.blingapp.Fragments.Categories.c3_BodyInjuriesFragment;
import com.systemdict32.blingapp.Fragments.Categories.c4_SevereWoundsFragment;
import com.systemdict32.blingapp.Fragments.Categories.c5_SeriousIncidentsFragment;
import com.systemdict32.blingapp.Fragments.Categories.c6_CarAccidentFragment;
import com.systemdict32.blingapp.Fragments.Categories.c7_RespiratoryProblemFragment;
import com.systemdict32.blingapp.Fragments.Categories.c8_OutdoorIncidentsFragment;
import com.systemdict32.blingapp.Fragments.Categories.c9_ForeignObjectsFragment;
import com.systemdict32.blingapp.Fragments.EmergencyFragment;
import com.systemdict32.blingapp.Fragments.FireStationFragment;
import com.systemdict32.blingapp.Fragments.HomeFragment;
import com.systemdict32.blingapp.Fragments.HospitalFragment;
import com.systemdict32.blingapp.Fragments.InstructionFragment;
import com.systemdict32.blingapp.Fragments.LGUFragment;
import com.systemdict32.blingapp.Fragments.MyAccountFragment;
import com.systemdict32.blingapp.Fragments.MyICEFragment;
import com.systemdict32.blingapp.Fragments.PoliceStationsFragment;
import com.systemdict32.blingapp.Fragments.ReadFirstAidFragment;
import com.systemdict32.blingapp.Fragments.SubCategories.c10_1_CprAdultFragment;
import com.systemdict32.blingapp.Fragments.SubCategories.c1_10_NoseBleedFragment;
import com.systemdict32.blingapp.Fragments.SubCategories.c1_12_SoreThroatFragment;
import com.systemdict32.blingapp.Fragments.SubCategories.c1_13_AbdominalPainFragment;
import com.systemdict32.blingapp.Fragments.SubCategories.c1_6_FaintingFragment;
import com.systemdict32.blingapp.Fragments.SubCategories.c1_7_MigraineFragment;
import com.systemdict32.blingapp.Fragments.SubCategories.c1_8_VomitingFragment;
import com.systemdict32.blingapp.Fragments.SubCategories.c2_1_BlistersFragment;
import com.systemdict32.blingapp.Fragments.SubCategories.c2_2_BruisingFragment;
import com.systemdict32.blingapp.Fragments.SubCategories.c2_8_CutAndScrapesFragment;
import com.systemdict32.blingapp.Fragments.SubCategories.c3_1_HeadInjuryFragment;
import com.systemdict32.blingapp.Fragments.SubCategories.c4_1_ShockFragment;
import com.systemdict32.blingapp.Fragments.SubCategories.c4_2_ExternalBleedingFragment;
import com.systemdict32.blingapp.Fragments.SubCategories.c4_4_ImpalementFragment;
import com.systemdict32.blingapp.Fragments.SubCategories.c5_10_EmergencyChildbirthFragment;
import com.systemdict32.blingapp.Fragments.SubCategories.c5_1_StrokeFragment;
import com.systemdict32.blingapp.Fragments.SubCategories.c5_2_DrowningFragment;
import com.systemdict32.blingapp.Fragments.SubCategories.c5_3_HeatStrokeFragment;
import com.systemdict32.blingapp.Fragments.SubCategories.c5_4_HeartAttackFragment;
import com.systemdict32.blingapp.Fragments.SubCategories.c7_4_HangingFragment;
import com.systemdict32.blingapp.Fragments.SubCategories.c7_5_InhalationFragment;
import com.systemdict32.blingapp.Fragments.SubCategories.c7_6_HyperventilationFragment;
import com.systemdict32.blingapp.Fragments.SubCategories.c7_7_AsthmaFragment;
import com.systemdict32.blingapp.Fragments.SubCategories.c8_1_SunburnFragment;
import com.systemdict32.blingapp.Fragments.SubCategories.c8_2_FrostbiteFragment;
import com.systemdict32.blingapp.Fragments.SubCategories.c8_3_DehydrationFragment;
import com.systemdict32.blingapp.Fragments.SubCategories.c8_4_HypothermiaFragment;
import com.systemdict32.blingapp.Fragments.SubCategories.c8_5_HeatExhaustionFragment;
import com.systemdict32.blingapp.Fragments.SubCategories.c9_1_TickBiteFragment;
import com.systemdict32.blingapp.Fragments.SubCategories.c9_2_SnakeBiteFragment;
import com.systemdict32.blingapp.Fragments.SubCategories.c9_7_DrugPoisoningFragment;
import com.systemdict32.blingapp.R;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class BlingChatbot {
    final Handler handler = new Handler();

    public BlingChatbot() {
    }

    public Intent STT() {
        Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, Locale.getDefault());
        intent.putExtra(RecognizerIntent.EXTRA_PROMPT, "Hi, say what you need about first aid.");
        return intent;
    }

    public TextToSpeech TTS(Context context, TextToSpeech.OnInitListener onInit) {
        TextToSpeech TTS = new TextToSpeech(context, onInit);
        return TTS;
    }

    public String MainChatbot(ArrayList<String> speechMessage, Context context, FragmentActivity activity) {
        String botMessage = "Pardon. Please try another word.";
        String userMessage = speechMessage.get(0);

        // ------------------------------------------ first aid categories -----------------------------------

        // c1 emergency basic
        if (userMessage.toLowerCase().contains("emergency basic") || userMessage.toLowerCase().contains("emergency first aid")
                || userMessage.toLowerCase().contains("cramp") || userMessage.toLowerCase().contains("cramps")
                || userMessage.toLowerCase().contains("unconscious") || userMessage.toLowerCase().contains("comatose")
                || userMessage.toLowerCase().contains("coma")) {
            FragmentTransaction ft = activity.getSupportFragmentManager().beginTransaction().replace(R.id.home_fragment_container, new c1_EmergencyBasicFragment());
            ft.addToBackStack("nav_home");
            ft.commit();

            botMessage = "Going to Emergency Basic Page";
        }
        if (userMessage.toLowerCase().contains("wound") || userMessage.toLowerCase().contains("wounds")) {
            FragmentTransaction ft = activity.getSupportFragmentManager().beginTransaction().replace(R.id.home_fragment_container, new c2_WoundsFragment());
            ft.addToBackStack("nav_home");
            ft.commit();

            botMessage = "Going to Wounds Page";
        }
        if (userMessage.toLowerCase().contains("body injury") || userMessage.toLowerCase().contains("body injuries")
                || userMessage.toLowerCase().contains("injury") || userMessage.toLowerCase().contains("injuries")) {
            FragmentTransaction ft = activity.getSupportFragmentManager().beginTransaction().replace(R.id.home_fragment_container, new c3_BodyInjuriesFragment());
            ft.addToBackStack("nav_home");
            ft.commit();

            botMessage = "Going to Body Injuries Page";
        }
        if (userMessage.toLowerCase().contains("severe wound") || userMessage.toLowerCase().contains("severe wounds")
                || userMessage.toLowerCase().contains("bleed") || userMessage.toLowerCase().contains("bleeding") || userMessage.toLowerCase().contains("bleeds")
                || userMessage.toLowerCase().contains("lose blood") || userMessage.toLowerCase().contains("blood")) {

            FragmentTransaction ft = activity.getSupportFragmentManager().beginTransaction().replace(R.id.home_fragment_container, new c4_SevereWoundsFragment());
            ft.addToBackStack("nav_home");
            ft.commit();

            botMessage = "Going to Severe Wounds Page";
        }
        if (userMessage.toLowerCase().contains("serious incident") || userMessage.toLowerCase().contains("serious incidents")
                || userMessage.toLowerCase().contains("incident") || userMessage.toLowerCase().contains("incidents") || userMessage.toLowerCase().contains("seizures")
                || userMessage.toLowerCase().contains("seizure") || userMessage.toLowerCase().contains("electric")) {
            FragmentTransaction ft = activity.getSupportFragmentManager().beginTransaction().replace(R.id.home_fragment_container, new c5_SeriousIncidentsFragment());
            ft.addToBackStack("nav_home");
            ft.commit();

            botMessage = "Going to Serious Incidents Page";
        }
        if (userMessage.toLowerCase().contains("car accident") || userMessage.toLowerCase().contains("car accidents")
                || userMessage.toLowerCase().contains("car injury") || userMessage.toLowerCase().contains("car injuries")
                || userMessage.toLowerCase().contains("burn") || userMessage.toLowerCase().contains("burns")
                || userMessage.toLowerCase().contains("fracture") || userMessage.toLowerCase().contains("fractures")) {
            FragmentTransaction ft = activity.getSupportFragmentManager().beginTransaction().replace(R.id.home_fragment_container, new c6_CarAccidentFragment());
            ft.addToBackStack("nav_home");
            ft.commit();

            botMessage = "Going to Car Accident Page";
        }
        if (userMessage.toLowerCase().contains("respiratory problem") || userMessage.toLowerCase().contains("respiratory problems")
                || userMessage.toLowerCase().contains("respiratory")) {
            FragmentTransaction ft = activity.getSupportFragmentManager().beginTransaction().replace(R.id.home_fragment_container, new c7_RespiratoryProblemFragment());
            ft.addToBackStack("nav_home");
            ft.commit();

            botMessage = "Going to Respiratory Problem Page";
        }
        if (userMessage.toLowerCase().contains("outdoor incident") || userMessage.toLowerCase().contains("outdoor incidents")
                || userMessage.toLowerCase().contains("outdoor accident") || userMessage.toLowerCase().contains("outdoor accidents")
                || userMessage.toLowerCase().contains("outside") || userMessage.toLowerCase().contains("outside")
                || userMessage.toLowerCase().contains("outdoor")) {
            FragmentTransaction ft = activity.getSupportFragmentManager().beginTransaction().replace(R.id.home_fragment_container, new c8_OutdoorIncidentsFragment());
            ft.addToBackStack("nav_home");
            ft.commit();

            botMessage = "Going to Outdoor Accident Page";
        }
        if (userMessage.toLowerCase().contains("foreign objects") || userMessage.toLowerCase().contains("foreign object")
                || userMessage.toLowerCase().contains("bite") || userMessage.toLowerCase().contains("bites")
                || userMessage.toLowerCase().contains("poisons") || userMessage.toLowerCase().contains("poison") || userMessage.toLowerCase().contains("poisonous") || userMessage.toLowerCase().contains("poisoning")
                || userMessage.toLowerCase().contains("sting") || userMessage.toLowerCase().contains("stings")
                || (userMessage.toLowerCase().contains("object") && userMessage.toLowerCase().contains("body"))) {
            FragmentTransaction ft = activity.getSupportFragmentManager().beginTransaction().replace(R.id.home_fragment_container, new c9_ForeignObjectsFragment());
            ft.addToBackStack("nav_home");
            ft.commit();

            botMessage = "Going to Foreign Objects Page";
        }
        // -------------------------------------------- first aid sub categories -------------------------------
        // c1 Emergency Basic
        if (userMessage.toLowerCase().contains("abdominal pain")) {
            FragmentTransaction ft = activity.getSupportFragmentManager().beginTransaction().replace(R.id.home_fragment_container, new c1_13_AbdominalPainFragment());
            ft.addToBackStack("nav_home");
            ft.commit();

            botMessage = "Going to Abdominal Pain Page";
        }
        if (userMessage.toLowerCase().contains("faint") || userMessage.toLowerCase().contains("fainting") || userMessage.toLowerCase().contains("dizzy")) {
            FragmentTransaction ft = activity.getSupportFragmentManager().beginTransaction().replace(R.id.home_fragment_container, new c1_6_FaintingFragment());
            ft.addToBackStack("nav_home");
            ft.commit();

            botMessage = "Going to Fainting Page";
        }
        if (userMessage.toLowerCase().contains("sore throat")) {
            FragmentTransaction ft = activity.getSupportFragmentManager().beginTransaction().replace(R.id.home_fragment_container, new c1_12_SoreThroatFragment());
            ft.addToBackStack("nav_home");
            ft.commit();

            botMessage = "Going to Sore Throat Page";
        }
        if (userMessage.toLowerCase().contains("migraine")) {
            FragmentTransaction ft = activity.getSupportFragmentManager().beginTransaction().replace(R.id.home_fragment_container, new c1_7_MigraineFragment());
            ft.addToBackStack("nav_home");
            ft.commit();

            botMessage = "Going to Migraine Page";
        }
        if (userMessage.contains("nose bleed")) {
            FragmentTransaction ft = activity.getSupportFragmentManager().beginTransaction().replace(R.id.home_fragment_container, new c1_10_NoseBleedFragment());
            ft.addToBackStack("nav_home");
            ft.commit();

            botMessage = "Going to Nose Bleed Page";
        }
        if (userMessage.toLowerCase().contains("diarrhea") || userMessage.toLowerCase().contains("vomiting")) {
            FragmentTransaction ft = activity.getSupportFragmentManager().beginTransaction().replace(R.id.home_fragment_container, new c1_8_VomitingFragment());
            ft.addToBackStack("nav_home");
            ft.commit();

            botMessage = "Going to Nose Bleed Page";
        }
        if (userMessage.toLowerCase().contains("head injury")) {
            FragmentTransaction ft = activity.getSupportFragmentManager().beginTransaction().replace(R.id.home_fragment_container, new c3_1_HeadInjuryFragment());
            ft.addToBackStack("nav_home");
            ft.commit();

            botMessage = "Going to Head Injuries Page";
        }
        // c2 wounds
        if (userMessage.toLowerCase().contains("cut")) {
            FragmentTransaction ft = activity.getSupportFragmentManager().beginTransaction().replace(R.id.home_fragment_container, new c2_8_CutAndScrapesFragment());
            ft.addToBackStack("nav_home");
            ft.commit();

            botMessage = "Going to Cut and Scrapes Page";
        }
        if (userMessage.toLowerCase().contains("blister") || userMessage.toLowerCase().contains("blisters")) {
            FragmentTransaction ft = activity.getSupportFragmentManager().beginTransaction().replace(R.id.home_fragment_container, new c2_1_BlistersFragment());
            ft.addToBackStack("nav_home");
            ft.commit();

            botMessage = "Going to Blisters Page";
        }
        if (userMessage.toLowerCase().contains("bruising")) {
            FragmentTransaction ft = activity.getSupportFragmentManager().beginTransaction().replace(R.id.home_fragment_container, new c2_2_BruisingFragment());
            ft.addToBackStack("nav_home");
            ft.commit();

            botMessage = "Going to Bruising Page";
        }
        // c4 SEVERE WOUNDS
        if (userMessage.toLowerCase().contains("shock")) {
            FragmentTransaction ft = activity.getSupportFragmentManager().beginTransaction().replace(R.id.home_fragment_container, new c4_1_ShockFragment());
            ft.addToBackStack("nav_home");
            ft.commit();

            botMessage = "Going to Shock Page";
        }
        if (userMessage.toLowerCase().contains("external bleeding") || userMessage.toLowerCase().contains("external bleed")) {
            FragmentTransaction ft = activity.getSupportFragmentManager().beginTransaction().replace(R.id.home_fragment_container, new c4_2_ExternalBleedingFragment());
            ft.addToBackStack("nav_home");
            ft.commit();

            botMessage = "Going to External Bleeding Page";
        }
        if (userMessage.toLowerCase().contains("impale") || userMessage.toLowerCase().contains("impalement")) {
            FragmentTransaction ft = activity.getSupportFragmentManager().beginTransaction().replace(R.id.home_fragment_container, new c4_4_ImpalementFragment());
            ft.addToBackStack("nav_home");
            ft.commit();

            botMessage = "Going to Impalement Page";
        }
        // c5 serious accidents
        if (userMessage.toLowerCase().contains("stroke")) {
            FragmentTransaction ft = activity.getSupportFragmentManager().beginTransaction().replace(R.id.home_fragment_container, new c5_1_StrokeFragment());
            ft.addToBackStack("nav_home");
            ft.commit();

            botMessage = "Going to Stroke Page";
        }
        if (userMessage.toLowerCase().contains("drown") || userMessage.toLowerCase().contains("drowning")) {
            FragmentTransaction ft = activity.getSupportFragmentManager().beginTransaction().replace(R.id.home_fragment_container, new c5_2_DrowningFragment());
            ft.addToBackStack("nav_home");
            ft.commit();

            botMessage = "Going to Drowning Page";
        }
        if (userMessage.toLowerCase().contains("heat stroke")) {
            FragmentTransaction ft = activity.getSupportFragmentManager().beginTransaction().replace(R.id.home_fragment_container, new c5_3_HeatStrokeFragment());
            ft.addToBackStack("nav_home");
            ft.commit();

            botMessage = "Going to Heat Stroke Page";
        }
        if (userMessage.toLowerCase().contains("heart attack")) {
            FragmentTransaction ft = activity.getSupportFragmentManager().beginTransaction().replace(R.id.home_fragment_container, new c5_4_HeartAttackFragment());
            ft.addToBackStack("nav_home");
            ft.commit();

            botMessage = "Going to Heart Attack Page";
        }
        if (userMessage.toLowerCase().contains("child birth")) {
            FragmentTransaction ft = activity.getSupportFragmentManager().beginTransaction().replace(R.id.home_fragment_container, new c5_10_EmergencyChildbirthFragment());
            ft.addToBackStack("nav_home");
            ft.commit();

            botMessage = "Going to Emergency Child Birth Page";
        }
        // c7 respiratory problem
        if (userMessage.toLowerCase().contains("hanging") || userMessage.toLowerCase().contains("strangulation")) {
            FragmentTransaction ft = activity.getSupportFragmentManager().beginTransaction().replace(R.id.home_fragment_container, new c7_4_HangingFragment());
            ft.addToBackStack("nav_home");
            ft.commit();

            botMessage = "Going to Hanging & Strangulation Page";
        }
        if (userMessage.toLowerCase().contains("fumes") || userMessage.toLowerCase().contains("chemical")) {
            FragmentTransaction ft = activity.getSupportFragmentManager().beginTransaction().replace(R.id.home_fragment_container, new c7_5_InhalationFragment());
            ft.addToBackStack("nav_home");
            ft.commit();

            botMessage = "Going to Inhalation of Fumes Page";
        }
        if (userMessage.toLowerCase().contains("hyperventilation")) {
            FragmentTransaction ft = activity.getSupportFragmentManager().beginTransaction().replace(R.id.home_fragment_container, new c7_6_HyperventilationFragment());
            ft.addToBackStack("nav_home");
            ft.commit();

            botMessage = "Going to Hyperventilation Page";
        }
        if (userMessage.toLowerCase().contains("asthma")) {
            FragmentTransaction ft = activity.getSupportFragmentManager().beginTransaction().replace(R.id.home_fragment_container, new c7_7_AsthmaFragment());
            ft.addToBackStack("nav_home");
            ft.commit();

            botMessage = "Going to Asthma Page";
        }
        // c8 outdoor incidents
        if (userMessage.toLowerCase().contains("sunburn")) {
            FragmentTransaction ft = activity.getSupportFragmentManager().beginTransaction().replace(R.id.home_fragment_container, new c8_1_SunburnFragment());
            ft.addToBackStack("nav_home");
            ft.commit();

            botMessage = "Going to Sunburn Page";
        }
        if (userMessage.toLowerCase().contains("frostbite")) {
            FragmentTransaction ft = activity.getSupportFragmentManager().beginTransaction().replace(R.id.home_fragment_container, new c8_2_FrostbiteFragment());
            ft.addToBackStack("nav_home");
            ft.commit();

            botMessage = "Going to Frostbite Page";
        }
        if (userMessage.toLowerCase().contains("dehydration") || userMessage.toLowerCase().contains("dehydrate")) {
            FragmentTransaction ft = activity.getSupportFragmentManager().beginTransaction().replace(R.id.home_fragment_container, new c8_3_DehydrationFragment());
            ft.addToBackStack("nav_home");
            ft.commit();

            botMessage = "Going to Dehydration Page";
        }
        if (userMessage.toLowerCase().contains("hypothermia")) {
            FragmentTransaction ft = activity.getSupportFragmentManager().beginTransaction().replace(R.id.home_fragment_container, new c8_4_HypothermiaFragment());
            ft.addToBackStack("nav_home");
            ft.commit();

            botMessage = "Going to Hypothermia Page";
        }
        if (userMessage.toLowerCase().contains("heat exhaustion") || userMessage.toLowerCase().contains("heat exhaust")) {
            FragmentTransaction ft = activity.getSupportFragmentManager().beginTransaction().replace(R.id.home_fragment_container, new c8_5_HeatExhaustionFragment());
            ft.addToBackStack("nav_home");
            ft.commit();

            botMessage = "Going to Heat Exhaustion Page";
        }
        // c9 foreign objects
        if (userMessage.toLowerCase().contains("snake bite")) {
            FragmentTransaction ft = activity.getSupportFragmentManager().beginTransaction().replace(R.id.home_fragment_container, new c9_2_SnakeBiteFragment());
            ft.addToBackStack("nav_home");
            ft.commit();

            botMessage = "Going to Snake Bite Page";
        }
        if (userMessage.toLowerCase().contains("drug poison") || userMessage.toLowerCase().contains("drug poisoning")) {
            FragmentTransaction ft = activity.getSupportFragmentManager().beginTransaction().replace(R.id.home_fragment_container, new c9_7_DrugPoisoningFragment());
            ft.addToBackStack("nav_home");
            ft.commit();

            botMessage = "Going to Drug Poisoning Page";
        }
        // c10
        // first aid basic
        if (userMessage.toLowerCase().contains("first aid basic") || userMessage.toLowerCase().contains("First aid basic")) {
            FragmentTransaction ft = activity.getSupportFragmentManager().beginTransaction().replace(R.id.home_fragment_container, new c10_FirstAidBasicFragment());
            ft.addToBackStack("nav_home");
            ft.commit();

            botMessage = "Going to First Aid Basic Page";
        }
        if (userMessage.toLowerCase().contains("cpr") || userMessage.toLowerCase().contains("C.P.R.") || userMessage.toLowerCase().contains("c.p.r")) {
            FragmentTransaction ft = activity.getSupportFragmentManager().beginTransaction().replace(R.id.home_fragment_container, new c10_1_CprFragment());
            ft.addToBackStack("nav_home");
            ft.commit();

            botMessage = "Going to CPR Page";
        }
        if (userMessage.toLowerCase().contains("vital signs") || userMessage.toLowerCase().contains("vital sign")) {
            FragmentTransaction ft = activity.getSupportFragmentManager().beginTransaction().replace(R.id.home_fragment_container, new c10_2_VitalSignsFragment());
            ft.addToBackStack("nav_home");
            ft.commit();

            botMessage = "Going to Vital Signs Page";
        }
        if (userMessage.toLowerCase().contains("choke") || userMessage.toLowerCase().contains("choking")) {
            FragmentTransaction ft = activity.getSupportFragmentManager().beginTransaction().replace(R.id.home_fragment_container, new c10_3_ChokingsFragment());
            ft.addToBackStack("nav_home");
            ft.commit();

            botMessage = "Going to Choking Page";
        }
        if (userMessage.toLowerCase().contains("Bandage") || userMessage.toLowerCase().contains("Bandages")) {
            FragmentTransaction ft = activity.getSupportFragmentManager().beginTransaction().replace(R.id.home_fragment_container, new c10_4_BandagesFragment());
            ft.addToBackStack("nav_home");
            ft.commit();

            botMessage = "Going to Bandages Page";
        }
        // emergency services
        if (userMessage.toLowerCase().contains("medic") || userMessage.toLowerCase().contains("hospital") || userMessage.toLowerCase().contains("medical")) {
            FragmentTransaction ft = activity.getSupportFragmentManager().beginTransaction().replace(R.id.home_fragment_container, new HospitalFragment());
            ft.addToBackStack("nav_home");
            ft.commit();

            botMessage = "Going to Nearby Hospital Page";
        }
        if (userMessage.toLowerCase().contains("police")) {
            FragmentTransaction ft = activity.getSupportFragmentManager().beginTransaction().replace(R.id.home_fragment_container, new PoliceStationsFragment());
            ft.addToBackStack("nav_home");
            ft.commit();

            botMessage = "Going to Nearby Police Station Page";
        }
        if (userMessage.toLowerCase().contains("firefighter") || userMessage.toLowerCase().contains("fire station") || userMessage.toLowerCase().contains("fireman")) {
            FragmentTransaction ft = activity.getSupportFragmentManager().beginTransaction().replace(R.id.home_fragment_container, new FireStationFragment());
            ft.addToBackStack("nav_home");
            ft.commit();

            botMessage = "Going to Nearby Fire Station Page";
        }
        if (userMessage.toLowerCase().contains("hot lines") || userMessage.toLowerCase().contains("hot line")
                || userMessage.toLowerCase().contains("hotlines") || userMessage.toLowerCase().contains("hotline")) {
            FragmentTransaction ft = activity.getSupportFragmentManager().beginTransaction().replace(R.id.home_fragment_container, new LGUFragment());
            ft.addToBackStack("nav_home");
            ft.commit();

            botMessage = "Going to L.G.U. Hotlines Page";
        }
        if (userMessage.compareToIgnoreCase("hello") == 0) {
            botMessage = "Hi, I'm Bling App";
        }
        return botMessage;
    }

    public String HashPassword(String password) {
        String hashedPassword = null;
        try {
            // Create MessageDigest instance for MD5
            MessageDigest md = MessageDigest.getInstance("MD5");
            //Add password bytes to digest
            md.update(password.getBytes());
            //Get the hash's bytes
            byte[] bytes = md.digest();
            //This bytes[] has bytes in decimal format;
            //Convert it to hexadecimal format
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < bytes.length; i++) {
                sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
            }
            //Get complete hashed password in hex format
            hashedPassword = sb.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return hashedPassword;
    }
}
