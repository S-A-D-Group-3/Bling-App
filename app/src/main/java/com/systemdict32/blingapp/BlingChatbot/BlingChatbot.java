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
import com.systemdict32.blingapp.Fragments.MyAccountFragment;
import com.systemdict32.blingapp.Fragments.MyICEFragment;
import com.systemdict32.blingapp.Fragments.PoliceStationsFragment;
import com.systemdict32.blingapp.Fragments.ReadFirstAidFragment;
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

        // ------------------------------------------ instruction set -----------------------------------

        if (userMessage.contains("first aid")) {
            FragmentTransaction ft = activity.getSupportFragmentManager().beginTransaction().replace(R.id.home_fragment_container, new InstructionFragment());
            ft.addToBackStack("nav_home");
            ft.commit();

            botMessage = "Going to First Aid Instruction Page";
        }
        // ------------------------------------------ first aid categories -----------------------------------
        if (userMessage.contains("emergency basic") || userMessage.contains("emergency first aid")
                || userMessage.contains("cramp") || userMessage.contains("cramps")
                || userMessage.contains("unconscious") || userMessage.contains("comatose")
                || userMessage.contains("coma")) {
            FragmentTransaction ft = activity.getSupportFragmentManager().beginTransaction().replace(R.id.home_fragment_container, new c1_EmergencyBasicFragment());
            ft.addToBackStack("nav_home");
            ft.commit();

            botMessage = "Going to Emergency Basic Page";
        }
        if (userMessage.contains("wound") || userMessage.contains("wounds")
                || userMessage.contains("bruise") || userMessage.contains("bruises")) {
            FragmentTransaction ft = activity.getSupportFragmentManager().beginTransaction().replace(R.id.home_fragment_container, new c2_WoundsFragment());
            ft.addToBackStack("nav_home");
            ft.commit();

            botMessage = "Going to Wounds Page";
        }
        if (userMessage.contains("body injury") || userMessage.contains("body injuries")
                || userMessage.contains("injury") || userMessage.contains("injuries")) {
            FragmentTransaction ft = activity.getSupportFragmentManager().beginTransaction().replace(R.id.home_fragment_container, new c3_BodyInjuriesFragment());
            ft.addToBackStack("nav_home");
            ft.commit();

            botMessage = "Going to Body Injuries Page";
        }
        if (userMessage.contains("severe wound") || userMessage.contains("severe wounds")
                || userMessage.contains("bleed") || userMessage.contains("bleeding") || userMessage.contains("bleeds")
                || userMessage.contains("lose blood") || userMessage.contains("blood")) {
            FragmentTransaction ft = activity.getSupportFragmentManager().beginTransaction().replace(R.id.home_fragment_container, new c4_SevereWoundsFragment());
            ft.addToBackStack("nav_home");
            ft.commit();

            botMessage = "Going to Severe Wounds Page";
        }
        if (userMessage.contains("serious incident") || userMessage.contains("serious incidents")
                || userMessage.contains("incident") || userMessage.contains("incidents") || userMessage.contains("seizures")
                || userMessage.contains("seizure") || userMessage.contains("electric")) {
            FragmentTransaction ft = activity.getSupportFragmentManager().beginTransaction().replace(R.id.home_fragment_container, new c5_SeriousIncidentsFragment());
            ft.addToBackStack("nav_home");
            ft.commit();

            botMessage = "Going to Serious Incidents Page";
        }
        if (userMessage.contains("car accident") || userMessage.contains("car accidents")
                || userMessage.contains("car injury") || userMessage.contains("car injuries")
                || userMessage.contains("burn") || userMessage.contains("burns")
                || userMessage.contains("fracture") || userMessage.contains("fractures")) {
            FragmentTransaction ft = activity.getSupportFragmentManager().beginTransaction().replace(R.id.home_fragment_container, new c6_CarAccidentFragment());
            ft.addToBackStack("nav_home");
            ft.commit();

            botMessage = "Going to Car Accident Page";
        }
        if (userMessage.contains("respiratory problem") || userMessage.contains("respiratory problems")
                || userMessage.contains("respiratory")
                || userMessage.contains("choke") || userMessage.contains("choking")) {
            FragmentTransaction ft = activity.getSupportFragmentManager().beginTransaction().replace(R.id.home_fragment_container, new c7_RespiratoryProblemFragment());
            ft.addToBackStack("nav_home");
            ft.commit();

            botMessage = "Going to Respiratory Problem Page";
        }
        if (userMessage.contains("outdoor incident") || userMessage.contains("outdoor incidents")
                || userMessage.contains("outdoor accident") || userMessage.contains("outdoor accidents")
                || userMessage.contains("outside") || userMessage.contains("outside")
                || userMessage.contains("outdoor") || userMessage.contains("outdoor")) {
            FragmentTransaction ft = activity.getSupportFragmentManager().beginTransaction().replace(R.id.home_fragment_container, new c8_OutdoorIncidentsFragment());
            ft.addToBackStack("nav_home");
            ft.commit();

            botMessage = "Going to Outdoor Accident Page";
        }
        if (userMessage.contains("foreign objects") || userMessage.contains("foreign object")
                || userMessage.contains("bite") || userMessage.contains("bites")
                || userMessage.contains("poisons") || userMessage.contains("poison") || userMessage.contains("poisonous") || userMessage.contains("poisoning")
                || userMessage.contains("sting") || userMessage.contains("stings")
                || (userMessage.contains("object") && userMessage.contains("body"))) {
            FragmentTransaction ft = activity.getSupportFragmentManager().beginTransaction().replace(R.id.home_fragment_container, new c9_ForeignObjectsFragment());
            ft.addToBackStack("nav_home");
            ft.commit();

            botMessage = "Going to Foreign Objects Page";
        }
        // -------------------------------------------- first aid sub categories -------------------------------
        // c1 Emergency Basic
        if (userMessage.contains("abdominal pain")) {
            FragmentTransaction ft = activity.getSupportFragmentManager().beginTransaction().replace(R.id.home_fragment_container, new c1_13_AbdominalPainFragment());
            ft.addToBackStack("nav_home");
            ft.commit();

            botMessage = "Going to Abdominal Pain Page";
        }
        if (userMessage.contains("faint") || userMessage.contains("fainting") || userMessage.contains("dizzy")) {
            FragmentTransaction ft = activity.getSupportFragmentManager().beginTransaction().replace(R.id.home_fragment_container, new c1_6_FaintingFragment());
            ft.addToBackStack("nav_home");
            ft.commit();

            botMessage = "Going to Fainting Page";
        }
        if (userMessage.contains("sore throat")) {
            FragmentTransaction ft = activity.getSupportFragmentManager().beginTransaction().replace(R.id.home_fragment_container, new c1_12_SoreThroatFragment());
            ft.addToBackStack("nav_home");
            ft.commit();

            botMessage = "Going to Sore Throat Page";
        }
        if (userMessage.contains("migraine")) {
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
        if (userMessage.contains("diarrhea") || userMessage.contains("vomiting")) {
            FragmentTransaction ft = activity.getSupportFragmentManager().beginTransaction().replace(R.id.home_fragment_container, new c1_8_VomitingFragment());
            ft.addToBackStack("nav_home");
            ft.commit();

            botMessage = "Going to Nose Bleed Page";
        }
        if (userMessage.contains("head injury")) {
            FragmentTransaction ft = activity.getSupportFragmentManager().beginTransaction().replace(R.id.home_fragment_container, new c3_1_HeadInjuryFragment());
            ft.addToBackStack("nav_home");
            ft.commit();

            botMessage = "Going to Head Injuries Page";
        }
        // c2 wounds
        if (userMessage.contains("cut")) {
            FragmentTransaction ft = activity.getSupportFragmentManager().beginTransaction().replace(R.id.home_fragment_container, new c2_8_CutAndScrapesFragment());
            ft.addToBackStack("nav_home");
            ft.commit();

            botMessage = "Going to Cut and Scrapes Page";
        }
        if (userMessage.contains("blister") || userMessage.contains("blisters")) {
            FragmentTransaction ft = activity.getSupportFragmentManager().beginTransaction().replace(R.id.home_fragment_container, new c2_1_BlistersFragment());
            ft.addToBackStack("nav_home");
            ft.commit();

            botMessage = "Going to Blisters Page";
        }
        if (userMessage.contains("bruising")) {
            FragmentTransaction ft = activity.getSupportFragmentManager().beginTransaction().replace(R.id.home_fragment_container, new c2_2_BruisingFragment());
            ft.addToBackStack("nav_home");
            ft.commit();

            botMessage = "Going to Blisters Page";
        }
        // c4 SEVERE WOUNDS
        if (userMessage.contains("shock")) {
            FragmentTransaction ft = activity.getSupportFragmentManager().beginTransaction().replace(R.id.home_fragment_container, new c4_1_ShockFragment());
            ft.addToBackStack("nav_home");
            ft.commit();

            botMessage = "Going to Shock Page";
        }
        if (userMessage.contains("external bleeding") || userMessage.contains("external bleed")) {
            FragmentTransaction ft = activity.getSupportFragmentManager().beginTransaction().replace(R.id.home_fragment_container, new c4_2_ExternalBleedingFragment());
            ft.addToBackStack("nav_home");
            ft.commit();

            botMessage = "Going to External Bleeding Page";
        }
        if (userMessage.contains("impale") || userMessage.contains("impalement")) {
            FragmentTransaction ft = activity.getSupportFragmentManager().beginTransaction().replace(R.id.home_fragment_container, new c4_4_ImpalementFragment());
            ft.addToBackStack("nav_home");
            ft.commit();

            botMessage = "Going to Impalement Page";
        }
        if (userMessage.contains("impale") || userMessage.contains("impalement")) {
            FragmentTransaction ft = activity.getSupportFragmentManager().beginTransaction().replace(R.id.home_fragment_container, new c4_4_ImpalementFragment());
            ft.addToBackStack("nav_home");
            ft.commit();

            botMessage = "Going to Impalement Page";
        }
        // c5 serious accidents
        if (userMessage.contains("stroke")) {
            FragmentTransaction ft = activity.getSupportFragmentManager().beginTransaction().replace(R.id.home_fragment_container, new c5_1_StrokeFragment());
            ft.addToBackStack("nav_home");
            ft.commit();

            botMessage = "Going to Stroke Page";
        }
        if (userMessage.contains("drown") || userMessage.contains("drowning")) {
            FragmentTransaction ft = activity.getSupportFragmentManager().beginTransaction().replace(R.id.home_fragment_container, new c5_2_DrowningFragment());
            ft.addToBackStack("nav_home");
            ft.commit();

            botMessage = "Going to Drowning Page";
        }
        if (userMessage.contains("heat stroke")) {
            FragmentTransaction ft = activity.getSupportFragmentManager().beginTransaction().replace(R.id.home_fragment_container, new c5_3_HeatStrokeFragment());
            ft.addToBackStack("nav_home");
            ft.commit();

            botMessage = "Going to Heat Stroke Page";
        }
        if (userMessage.contains("heart attack")) {
            FragmentTransaction ft = activity.getSupportFragmentManager().beginTransaction().replace(R.id.home_fragment_container, new c5_4_HeartAttackFragment());
            ft.addToBackStack("nav_home");
            ft.commit();

            botMessage = "Going to Heart Attack Page";
        }
        if (userMessage.contains("child birth")) {
            FragmentTransaction ft = activity.getSupportFragmentManager().beginTransaction().replace(R.id.home_fragment_container, new c5_10_EmergencyChildbirthFragment());
            ft.addToBackStack("nav_home");
            ft.commit();

            botMessage = "Going to Emergency Child Birth Page";
        }
        // c7 respiratory problem
        if (userMessage.contains("hanging") || userMessage.contains("strangulation")) {
            FragmentTransaction ft = activity.getSupportFragmentManager().beginTransaction().replace(R.id.home_fragment_container, new c7_4_HangingFragment());
            ft.addToBackStack("nav_home");
            ft.commit();

            botMessage = "Going to Hanging & Strangulation Page";
        }
        if (userMessage.contains("fumes") || userMessage.contains("chemical")) {
            FragmentTransaction ft = activity.getSupportFragmentManager().beginTransaction().replace(R.id.home_fragment_container, new c7_5_InhalationFragment());
            ft.addToBackStack("nav_home");
            ft.commit();

            botMessage = "Going to Inhalation of Fumes Page";
        }
        if (userMessage.contains("hyperventilation")) {
            FragmentTransaction ft = activity.getSupportFragmentManager().beginTransaction().replace(R.id.home_fragment_container, new c7_6_HyperventilationFragment());
            ft.addToBackStack("nav_home");
            ft.commit();

            botMessage = "Going to Hyperventilation Page";
        }
        if (userMessage.contains("asthma")) {
            FragmentTransaction ft = activity.getSupportFragmentManager().beginTransaction().replace(R.id.home_fragment_container, new c7_7_AsthmaFragment());
            ft.addToBackStack("nav_home");
            ft.commit();

            botMessage = "Going to Asthma Page";
        }
        // c8 outdoor incidents
        if (userMessage.contains("sunburn")) {
            FragmentTransaction ft = activity.getSupportFragmentManager().beginTransaction().replace(R.id.home_fragment_container, new c8_1_SunburnFragment());
            ft.addToBackStack("nav_home");
            ft.commit();

            botMessage = "Going to Sunburn Page";
        }
        if (userMessage.contains("frostbite")) {
            FragmentTransaction ft = activity.getSupportFragmentManager().beginTransaction().replace(R.id.home_fragment_container, new c8_2_FrostbiteFragment());
            ft.addToBackStack("nav_home");
            ft.commit();

            botMessage = "Going to Frostbite Page";
        }
        if (userMessage.contains("dehydration") || userMessage.contains("dehydrate")) {
            FragmentTransaction ft = activity.getSupportFragmentManager().beginTransaction().replace(R.id.home_fragment_container, new c8_3_DehydrationFragment());
            ft.addToBackStack("nav_home");
            ft.commit();

            botMessage = "Going to Dehydration Page";
        }
        if (userMessage.contains("hypothermia")) {
            FragmentTransaction ft = activity.getSupportFragmentManager().beginTransaction().replace(R.id.home_fragment_container, new c8_4_HypothermiaFragment());
            ft.addToBackStack("nav_home");
            ft.commit();

            botMessage = "Going to Hypothermia Page";
        }
        if (userMessage.contains("heat exhaustion") || userMessage.contains("heat exhaust")) {
            FragmentTransaction ft = activity.getSupportFragmentManager().beginTransaction().replace(R.id.home_fragment_container, new c8_5_HeatExhaustionFragment());
            ft.addToBackStack("nav_home");
            ft.commit();

            botMessage = "Going to Heat Exhaustion Page";
        }
        // c9 foreign objects
        if (userMessage.contains("tic bite")) {
            FragmentTransaction ft = activity.getSupportFragmentManager().beginTransaction().replace(R.id.home_fragment_container, new c9_1_TickBiteFragment());
            ft.addToBackStack("nav_home");
            ft.commit();

            botMessage = "Going to Tick Bite Page";
        }
        if (userMessage.contains("snake bite")) {
            FragmentTransaction ft = activity.getSupportFragmentManager().beginTransaction().replace(R.id.home_fragment_container, new c9_2_SnakeBiteFragment());
            ft.addToBackStack("nav_home");
            ft.commit();

            botMessage = "Going to Snake Bite Page";
        }
        if (userMessage.contains("drug poison") || userMessage.contains("drug poisoning")) {
            FragmentTransaction ft = activity.getSupportFragmentManager().beginTransaction().replace(R.id.home_fragment_container, new c9_7_DrugPoisoningFragment());
            ft.addToBackStack("nav_home");
            ft.commit();

            botMessage = "Going to Drug Poisoning Page";
        }
        // emergency services
        if (userMessage.contains("medic") || userMessage.contains("hospital") || userMessage.contains("medical")) {
            FragmentTransaction ft = activity.getSupportFragmentManager().beginTransaction().replace(R.id.home_fragment_container, new HospitalFragment());
            ft.addToBackStack("nav_home");
            ft.commit();

            botMessage = "Going to Nearby Hospital Page";
        }
        if (userMessage.contains("police")) {
            FragmentTransaction ft = activity.getSupportFragmentManager().beginTransaction().replace(R.id.home_fragment_container, new PoliceStationsFragment());
            ft.addToBackStack("nav_home");
            ft.commit();

            botMessage = "Going to Nearby Police Station Page";
        }
        if (userMessage.contains("fire fighter") || userMessage.contains("fire station")) {
            FragmentTransaction ft = activity.getSupportFragmentManager().beginTransaction().replace(R.id.home_fragment_container, new FireStationFragment());
            ft.addToBackStack("nav_home");
            ft.commit();

            botMessage = "Going to Nearby Fire Station Page";
        }
        if (userMessage.compareToIgnoreCase("hello") == 0) {
            botMessage = "Hi, I'm Bling App";
        }
        if (userMessage.compareToIgnoreCase("emergency") == 0) {
            botMessage = "Calling 911.";
            Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel: 911"));
            context.startActivity(intent);
        }
        if (userMessage.compareToIgnoreCase("hotline") == 0) {
            botMessage = "Hello, what is your emergency?";
        }
        if (userMessage.compareToIgnoreCase("thank you") == 0 || userMessage.compareToIgnoreCase("thanks") == 0) {
            botMessage = "Thank you for using bling app";
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Do something after 5s = 5000ms
//                    Intent intent = new Intent(context, MainActivity.class);
//                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
//                    intent.putExtra("EXIT", true);
//                    context.startActivity(intent);
                }
            }, 1500);
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
