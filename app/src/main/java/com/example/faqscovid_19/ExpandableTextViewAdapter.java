package com.example.faqscovid_19;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

public class ExpandableTextViewAdapter extends BaseExpandableListAdapter {

    Context context;

    String[] questions = {
            "Why is the disease being called coronavirus disease 2019, COVID-19?",
            "What is a novel coronavirus?",
            "What is the source of the virus?",
            "How does the virus spread?",
            "Can COVID-19 be caught from a person who has no symptoms?",
            "Can someone who has had COVID-19 spread the illness to others?",
            "Can someone who has been quarantined for COVID-19 spread the illness to others?",
            "Can the virus that causes COVID-19 be spread through food, including restaurant take out, refrigerated or frozen packaged food?",
            "Can I get sick with COVID-19 if it is on food?",
            "Will warm weather stop the outbreak of COVID-19?",
            "What is community spread?",
            "What temperature kills the virus that causes COVID-19?",
            "What is the difference between self-isolation, self-quarantine and distancing?",
            "How long does it take after exposure to COVID-19 to develop symptoms?",
            "How long does the virus survive on surfaces?",
            "Can I catch COVID-19 from the faeces of someone with the disease?",
            "Can thermal scanners detect COVID-19?",
            "Can cold weather and snow kill the new coronavirus?",
            "Are hand dryers effective in killing the new coronavirus?",
            "Can regularly rinsing your nose with saline help prevent infection with the new coronavirus?",
            "Can eating garlic help prevent infection with the new coronavirus?",
            "Are people with high blood pressure (hypertension) at higher risk from COVID-19?",
            "Can I catch COVID-19 from my pet or other animals?",
            "Can animals carry the virus that causes COVID-19 on their skin or fur?",
            "Should I avoid contact with pets or other animals if I am sick with COVID-19?",
            "Can the virus that causes COVID-19 spread through drinking water?"
    };

    String[][] answers = {
            {"On February 11, 2020 the World Health Organization announced an official name for the disease that is causing the 2019 novel coronavirus outbreak, first identified in Wuhan China. The new name of this disease is coronavirus disease 2019, abbreviated as COVID-19. In COVID-19, ‘CO’ stands for ‘corona,’ ‘VI’ for ‘virus,’ and ‘D’ for disease. Formerly, this disease was referred to as “2019 novel coronavirus” or “2019-nCoV”."},
            {"A novel coronavirus is a new coronavirus that has not been previously identified. The virus causing coronavirus disease 2019 (COVID-19), is not the same as the coronaviruses that commonly circulate among humans and cause mild illness, like the common cold.\n" +
                    "\n" +
                    "A diagnosis with coronavirus 229E, NL63, OC43, or HKU1 is not the same as a COVID-19 diagnosis. Patients with COVID-19 will be evaluated and cared for differently than patients with common coronavirus diagnosis."},
            {"COVID-19 is caused by a coronavirus called SARS-CoV-2. Coronaviruses are a large family of viruses that are common in people and many different species of animals, including camels, cattle, cats, and bats.  Rarely, animal coronaviruses can infect people and then spread between people. This occurred with MERS-CoV and SARS-CoV, and now with the virus that causes COVID-19. The SARS-CoV-2 virus is a betacoronavirus, like MERS-CoV and SARS-CoV. All three of these viruses have their origins in bats. The sequences from U.S. patients are similar to the one that China initially posted, suggesting a likely single, recent emergence of this virus from an animal reservoir. However, the exact source of this virus is unknown."},
            {"The virus that causes COVID-19 is thought to spread mainly from person to person, mainly through respiratory droplets produced when an infected person coughs or sneezes. These droplets can land in the mouths or noses of people who are nearby or possibly be inhaled into the lungs. Spread is more likely when people are in close contact with one another (within about 6 feet).\n" +
                    "\n" +
                    "COVID-19 seems to be spreading easily and sustainably in the community (“community spread”) in many affected geographic areas. Community spread means people have been infected with the virus in an area, including some who are not sure how or where they became infected."},
            {"COVID-19 is mainly spread through respiratory droplets expelled by someone who is coughing or has other symptoms such as fever or tiredness. Many people with COVID-19 experience only mild symptoms. This is particularly true in the early stages of the disease. It is possible to catch COVID-19 from someone who has just a mild cough and does not feel ill.\n" +
                    "\n" +
                    "Some reports have indicated that people with no symptoms can transmit the virus. It is not yet known how often it happens. WHO is assessing ongoing research on the topic and will continue to share updated findings."},
            {"People can catch COVID-19 from others who have the virus. The disease spreads primarily from person to person through small droplets from the nose or mouth, which are expelled when a person with COVID-19 coughs, sneezes, or speaks. These droplets are relatively heavy, do not travel far and quickly sink to the ground. People can catch COVID-19 if they breathe in these droplets from a person infected with the virus.  This is why it is important to stay at least 1 meter) away from others. These droplets can land on objects and surfaces around the person such as tables, doorknobs and handrails.  People can become infected by touching these objects or surfaces, then touching their eyes, nose or mouth.  This is why it is important to wash your hands regularly with soap and water or clean with alcohol-based hand rub."},
            {"Quarantine means separating a person or group of people who have been exposed to a contagious disease but have not developed illness (symptoms) from others who have not been exposed, in order to prevent the possible spread of that disease. Quarantine is usually established for the incubation period of the communicable disease, which is the span of time during which people have developed illness after exposure. For COVID-19, the period of quarantine is 14 days from the last date of exposure because the incubation period for this virus is 2 to 14 days. Someone who has been released from COVID-19 quarantine is not considered a risk for spreading the virus to others because they have not developed illness during the incubation period."},
            {"Coronaviruses are generally thought to be spread from person to person through respiratory droplets. Currently, there is no evidence to support transmission of COVID-19 associated with food. Before preparing or eating food it is important to always wash your hands with soap and water for at least 20 seconds for general food safety. Throughout the day use a tissue to cover your coughing or sneezing, and wash your hands after blowing your nose, coughing or sneezing, or going to the bathroom.\n" +
                    "\n" +
                    "It may be possible that a person can get COVID-19 by touching a surface or object, like a packaging container, that has the virus on it and then touching their own mouth, nose, or possibly their eyes, but this is not thought to be the main way the virus spreads.\n" +
                    "\n" +
                    "In general, because of poor survivability of these coronaviruses on surfaces, there is likely very low risk of spread from food products or packaging."},
            {"Based on information about this novel coronavirus thus far, it seems unlikely that COVID-19 can be transmitted through food – additional investigation is needed."},
            {"It is not yet known whether weather and temperature affect the spread of COVID-19. Some other viruses, like those that cause the common cold and flu, spread more during cold weather months but that does not mean it is impossible to become sick with these viruses during other months.  There is much more to learn about the transmissibility, severity, and other features associated with COVID-19 and investigations are ongoing."},
            {"Community spread means people have been infected with the virus in an area, including some who are not sure how or where they became infected."},
            {"Generally coronaviruses survive for shorter periods at higher temperatures and higher humidity than in cooler or dryer environments. However, we don’t have direct data for this virus, nor do we have direct data for a temperature-based cutoff for inactivation at this point. The necessary temperature would also be based on the materials of the surface, the environment, etc."},
            {"Quarantine means restricting activities or separating people who are not ill themselves but may have been exposed to COVID-19. The goal is to prevent spread of the disease at the time when people just develop symptoms..\n" +
                    "\n" +
                    "Isolation means separating people who are ill with symptoms of COVID-19 and may be infectious to prevent the spread of the disease.\n" +
                    "\n" +
                    "Physical distancing means being physically apart. WHO recommends keeping at least 1-metre distance from others. This is a general measure that everyone should take even if they are well with no known exposure to COVID-19. "},
            {"The time between exposure to COVID-19 and the moment when symptoms start is commonly around five to six days but can range from 1 – 14 days."},
            {"The most important thing to know about coronavirus on surfaces is that they can easily be cleaned with common household disinfectants that will kill the virus. Studies have shown that the COVID-19 virus can survive for up to 72 hours on plastic and stainless steel, less than 4 hours on copper and less than 24 hours on cardboard.\n" +
                    "\n" +
                    "As, always clean your hands with an alcohol-based hand rub or wash them with soap and water. Avoid touching your eyes, mouth, or nose."},
            {"While initial investigations suggest the virus may be present in faeces in some cases, to date, there have not been reports of faecal-oral transmission of COVID-19. Additionally, there is no evidence to date on the survival of the COVID-19 virus in water or sewage.\n" +
                    "\n" +
                    "WHO is assessing ongoing research on the ways COVID-19 is spread and will continue to share new findings on this topic."},
            {"Thermal scanners are effective in detecting people who have a fever (i.e. have a higher than normal body temperature). They cannot detect people who are infected with COVID-19. There are many causes of fever. Call your healthcare provider if you need assistance or seek immediate medical care if you have fever and live in an area with malaria or dengue."},
            {"There is no reason to believe that cold weather can kill the new coronavirus or other diseases. The normal human body temperature remains around 36.5°C to 37°C, regardless of the external temperature or weather. The most effective way to protect yourself against the new coronavirus is by frequently cleaning your hands with alcohol-based hand rub or washing them with soap and water."},
            {"No. Hand dryers are not effective in killing the 2019-nCoV. To protect yourself against the new coronavirus, you should frequently clean your hands with an alcohol-based hand rub or wash them with soap and water. Once your hands are cleaned, you should dry them thoroughly by using paper towels or a warm air dryer."},
            {"No. There is no evidence that regularly rinsing the nose with saline has protected people from infection with the new coronavirus. \n" +
                    "\n" +
                    "There is some limited evidence that regularly rinsing nose with saline can help people recover more quickly from the common cold. However, regularly rinsing the nose has not been shown to prevent respiratory infections."},
            {"Garlic is a healthy food that may have some antimicrobial properties. However, there is no evidence from the current outbreak that eating garlic has protected people from the new coronavirus."},
            {"At this time, we do not think that people with high blood pressure and no other underlying health conditions are more likely than others to get severely ill from COVID-19. Although many people who have gotten severely ill from COVID-19 have high blood pressure, they are often older or have other medical conditions like obesity, diabetes, and serious heart conditions that place them at higher risk of severe illness from COVID-19.\n" +
                    "\n" +
                    "If you have high blood pressure, it’s critically important that you keep your blood pressure under control to lower your risk for heart disease and strokes. Take your blood pressure medications as directed, keep a log of your blood pressure every day if you are able to take your blood pressure at home, and work with your healthcare team to make sure your blood pressure is well controlled. Any changes to your medications should be made in consultation with your healthcare team."},
            {"Several dogs and cats (domestic cats and tigers) in contact with infected humans have tested positive for COVID-19. In addition, ferrets appear to be susceptible to the infection. In experimental conditions, both cats and ferrets were able to transmit infection to other animals of the same species. However, there is no evidence that these animals can transmit the disease to humans and spread COVID-19. COVID-19 is mainly spread through droplets produced when an infected person coughs, sneezes, or speaks.\n" +
                    "\n" +
                    "Minks raised in farms have also been detected with the virus. Most likely, they have been infected by farm workers. In a few instances, the minks that were infected by humans have transmitted the virus to other people. These are the first reported cases of animal-to-human transmission.\n" +
                    "\n" +
                    "It is still recommended that people who are sick with COVID-19 and people who are at risk limit contact with companion and other animals. When handling and caring for animals, basic hygiene measures should always be implemented. This includes hand washing after handling animals, their food or supplies, as well as avoiding kissing, licking or sharing food."},
            {"Although we know certain bacteria and fungi can be carried on fur and hair, there is no evidence that viruses, including the virus that causes COVID-19, can spread to people from the skin, fur, or hair of pets.\n" +
                    "\n" +
                    "However, because animals can sometimes carry other germs that can make people sick, it’s always a good idea to practice healthy habits around pets and other animals, including washing hands before and after interacting with them."},
            {"We are still learning about this virus, but it appears that it can spread from people to animals in some situations. Until we learn more about this new coronavirus, you should restrict contact with pets and other animals while you are sick with COVID-19, just like you would with people. When possible, have another member of your household care for your animals while you are sick. If you are sick with COVID-19, avoid contact with your pet."},
            {"The virus that causes COVID-19 has not been detected in drinking water. Conventional water treatment methods that use filtration and disinfection, such as those in most municipal drinking water systems, should remove or inactivate the virus that causes COVID-19."}
    };

    public ExpandableTextViewAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getGroupCount() {
        return questions.length;
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return answers[groupPosition].length;
    }

    @Override
    public Object getGroup(int groupPosition) {
        return questions[groupPosition];
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return answers[groupPosition][childPosition];
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {

        String questionFAQ = (String) getGroup(groupPosition);
        if(convertView == null)
        {
            LayoutInflater inflater = (LayoutInflater)this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.faq_question, null);
        }
        TextView text = convertView.findViewById(R.id.faq_question_view);
        text.setText(questionFAQ);

        return convertView;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {

        String answerFAQ = (String) getChild(groupPosition, childPosition);
        if(convertView == null)
        {
            LayoutInflater inflater = (LayoutInflater)this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.faq_answer, null);
        }
        TextView text = convertView.findViewById(R.id.faq_answer_view);
        text.setText(answerFAQ);

        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return false;
    }
}
