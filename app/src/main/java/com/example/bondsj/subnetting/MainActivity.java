package com.example.bondsj.subnetting;

import android.content.Intent;
import android.graphics.Color;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity
{
    AdView mAdview;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MobileAds.initialize(this,"ca-app-pub-6845925742732617~9464681857");
        mAdview = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdview.loadAd(adRequest);
        Button calcBtn = findViewById(R.id.calcBtn);
        RadioGroup rg = findViewById(R.id.radioGroup);
        //stores input
        final EditText firstOctIP = findViewById(R.id.firstOctIP);
        final EditText secondOctIP = findViewById(R.id.secondOctIP);
        final EditText thirdOctIP = findViewById(R.id.thirdOctIP);
        final EditText fourthOctIP = findViewById(R.id.fourthOctIP);
        final EditText cidrNote = findViewById(R.id.cidrNote);
        cidrNote.setEnabled(false);
        final EditText firstOctMask = findViewById(R.id.firstOctMask);
        final EditText secondOctMask = findViewById(R.id.secondOctMask);
        final EditText thirdOctMask = findViewById(R.id.thirdOctMask);
        final EditText fourthOctMask = findViewById(R.id.fourthOctMask);

        final TextInputLayout errorCheck = findViewById(R.id.textInputLayout1);
        final TextInputLayout errorCheck2 = findViewById(R.id.textInputLayout2);
        final TextInputLayout errorCheck3 = findViewById(R.id.textInputLayout3);
        final TextInputLayout errorCheck4 = findViewById(R.id.textInputLayout4);
        final TextInputLayout errorCheck5 = findViewById(R.id.textInputLayout5);
        final TextInputLayout errorCheck6 = findViewById(R.id.textInputLayout6);
        final TextInputLayout errorCheck7 = findViewById(R.id.textInputLayout7);
        final TextInputLayout errorCheck8 = findViewById(R.id.textInputLayout8);
        final TextInputLayout errorCheck9 = findViewById(R.id.textInputLayout9);

        //Condition for Radio Buttons
        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
                                      {@Override
                                          public void onCheckedChanged(RadioGroup group, int checkedId)
                                          {
                                              switch(checkedId)
                                              {
                                                  case R.id.Subnet_Radio:
                                                      firstOctMask.setEnabled(true);
                                                      secondOctMask.setEnabled(true);
                                                      thirdOctMask.setEnabled(true);
                                                      fourthOctMask.setEnabled(true);
                                                      cidrNote.setInputType(InputType.TYPE_NULL);
                                                      firstOctMask.setInputType(InputType.TYPE_CLASS_NUMBER);
                                                      secondOctMask.setInputType(InputType.TYPE_CLASS_NUMBER);
                                                      thirdOctMask.setInputType(InputType.TYPE_CLASS_NUMBER);
                                                      fourthOctMask.setInputType(InputType.TYPE_CLASS_NUMBER);
                                                      firstOctMask.setFocusableInTouchMode(true);
                                                      secondOctMask.setFocusableInTouchMode(true);
                                                      thirdOctMask.setFocusableInTouchMode(true);
                                                      fourthOctMask.setFocusableInTouchMode(true);
                                                      cidrNote.setEnabled(false);
                                                      cidrNote.setFocusableInTouchMode(false);
                                                      cidrNote.setVisibility(View.INVISIBLE);
                                                      firstOctMask.setVisibility(View.VISIBLE);
                                                      secondOctMask.setVisibility(View.VISIBLE);
                                                      thirdOctMask.setVisibility(View.VISIBLE);
                                                      fourthOctMask.setVisibility(View.VISIBLE);
                                                      findViewById(R.id.textView12).setVisibility(View.VISIBLE);
                                                      findViewById(R.id.textView13).setVisibility(View.VISIBLE);
                                                      findViewById(R.id.textView14).setVisibility(View.VISIBLE);
                                                      errorCheck5.setError(null);

                                                      break;
                                                  case R.id.CIDR_Radio:
                                                      firstOctMask.setEnabled(false);
                                                      secondOctMask.setEnabled(false);
                                                      thirdOctMask.setEnabled(false);
                                                      fourthOctMask.setEnabled(false);
                                                      firstOctMask.setInputType(InputType.TYPE_NULL);
                                                      secondOctMask.setInputType(InputType.TYPE_NULL);
                                                      thirdOctMask.setInputType(InputType.TYPE_NULL);
                                                      fourthOctMask.setInputType(InputType.TYPE_NULL);
                                                      cidrNote.setInputType(InputType.TYPE_CLASS_NUMBER);
                                                      firstOctMask.setFocusableInTouchMode(false);
                                                      secondOctMask.setFocusableInTouchMode(false);
                                                      thirdOctMask.setFocusableInTouchMode(false);
                                                      fourthOctMask.setFocusableInTouchMode(false);
                                                      cidrNote.setEnabled(true);
                                                      cidrNote.setFocusableInTouchMode(true);
                                                      cidrNote.setVisibility(View.VISIBLE);
                                                      firstOctMask.setVisibility(View.INVISIBLE);
                                                      secondOctMask.setVisibility(View.INVISIBLE);
                                                      thirdOctMask.setVisibility(View.INVISIBLE);
                                                      fourthOctMask.setVisibility(View.INVISIBLE);
                                                      findViewById(R.id.textView12).setVisibility(View.INVISIBLE);
                                                      findViewById(R.id.textView13).setVisibility(View.INVISIBLE);
                                                      findViewById(R.id.textView14).setVisibility(View.INVISIBLE);
                                                      errorCheck6.setError(null);
                                                      errorCheck7.setError(null);
                                                      errorCheck8.setError(null);
                                                      errorCheck9.setError(null);
                                                      break;

                                              }
                                          }
                                      });
        //Activation of Calculate Button
        calcBtn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {

                int[] netID1 = new int[8];
                int[] netID2 = new int[8];
                int[] netID3 = new int[8];
                int[] netID4 = new int[8];
                int[] broadIP1 = new int[8];
                int[] broadIP2 = new int[8];
                int[] broadIP3 = new int[8];
                int[] broadIP4 = new int[8];

                int newNetID1, newNetID2, newNetID3, newNetID4;
                int broad1, broad2, broad3, broad4;
                int hostsTotal, subTotal;

                //converts input to int
                int oct1ip = Integer.parseInt(firstOctIP.getText().toString());
                int oct2ip = Integer.parseInt(secondOctIP.getText().toString());
                int oct3ip = Integer.parseInt(thirdOctIP.getText().toString());
                int oct4ip = Integer.parseInt(fourthOctIP.getText().toString());
                int cidr = Integer.parseInt(cidrNote.getText().toString());
                int oct1Mask = Integer.parseInt(firstOctMask.getText().toString());
                int oct2Mask = Integer.parseInt(secondOctMask.getText().toString());
                int oct3Mask = Integer.parseInt(thirdOctMask.getText().toString());
                int oct4Mask = Integer.parseInt(fourthOctMask.getText().toString());

                //Convert CIDR to Subnet Mask
                RadioButton cr = findViewById(R.id.CIDR_Radio);
                if(cr.isChecked()==true)
                {
                    int[] cidrArray= changeCIDR(cidr);
                    oct1Mask=cidrArray[0];
                    oct2Mask=cidrArray[1];
                    oct3Mask=cidrArray[2];
                    oct4Mask=cidrArray[3];
                    errorCheck6.setError(null);
                    errorCheck7.setError(null);
                    errorCheck8.setError(null);
                    errorCheck9.setError(null);

                }
                //calculate CIDR from Subnet Mask
                else{
                    cidr = convertMask2Cidr(oct1Mask,oct2Mask,oct3Mask,oct4Mask);
                }
                //Error checking
                boolean test1 = validateFirstIP(oct1ip);
                boolean test2 = validateBasicOct(oct2ip);
                boolean test3 = validateBasicOct(oct3ip);
                boolean test4 = validateBasicOct(oct4ip);
                boolean test5 = validateMask(oct2Mask);
                boolean test6 = validateMask(oct3Mask);
                boolean test7 = validateMask(oct4Mask);
                boolean test8 = validateFirstMask(oct1Mask);
                boolean test9 = validateCidr(cidr);
                if (!test1)
                {
                    errorCheck.setError("Oops!");
                    return;
                }else{
                   errorCheck.setError(null);
                }

                if (!test8 || firstOctMask==null)
                {
                    errorCheck6.setError("Oops!");
                    return;
                }else{
                    errorCheck6.setError(null);
                }
                if (!test2 || secondOctIP==null)
                {
                    errorCheck2.setError("Oops!");
                    return;
                }else{
                    errorCheck2.setErrorEnabled(false);
                }
                if (!test3 || thirdOctIP==null)
                {
                    errorCheck3.setError("Oops!");
                    return;
                }else{
                    errorCheck3.setErrorEnabled(false);
                }
                if (!test4 || fourthOctIP==null)
                {
                    errorCheck4.setError("Oops!");
                    return;
                }else{
                    errorCheck4.setErrorEnabled(false);
                }
                if (!test5 || secondOctMask==null)
                {
                    errorCheck7.setError("Oops!");
                    return;
                }else{
                    errorCheck7.setErrorEnabled(false);
                }
                if (!test6 || thirdOctMask==null)
                {
                    errorCheck8.setError("Oops!");
                    return;
                }else{
                    errorCheck8.setErrorEnabled(false);
                }
                if (!test7 || fourthOctMask==null)
                {
                    errorCheck9.setError("Oops!");
                    return;
                }else{
                    errorCheck9.setErrorEnabled(false);
                }
                if(!test9 || cidrNote==null) {
                    errorCheck5.setError("Oops!");
                    return;
                }else{
                    errorCheck5.setErrorEnabled(false);
                }


                    //converts all integer numbers to Binary arrays for each octet
                    int[] binary1 = convertToBinary(oct1ip);
                    int[] binary2 = convertToBinary(oct2ip);
                    int[] binary3 = convertToBinary(oct3ip);
                    int[] binary4 = convertToBinary(oct4ip);
                    int[] binarySub1 = convertToBinary(oct1Mask);
                    int[] binarySub2 = convertToBinary(oct2Mask);
                    int[] binarySub3 = convertToBinary(oct3Mask);
                    int[] binarySub4 = convertToBinary(oct4Mask);


                    //Gets Network ID, but still in Binary Form
                    if (oct1Mask < 255)
                    {
                        netID1 = compareBinary(binary1, binarySub1);
                        //broadIP1 = compareBinaryBroad(binary1,binarySub1);
                        for (int i = 0; i < 8; i++)
                        {
                            netID2[i] = 0;
                            netID3[i] = 0;
                            netID4[i] = 0;
                        }
                    }
                    if (oct1Mask == 255 && oct2Mask < 255)
                    {
                        for (int i = 0; i < 8; i++)
                        {
                            netID3[i] = 0;
                            netID4[i] = 0;
                        }
                        netID1 = compareBinary(binary1, binarySub1);
                        //broadIP1 = compareBinaryBroad(binary1,binarySub1);
                        netID2 = compareBinary(binary2, binarySub2);
                        //broadIP2 = compareBinaryBroad(binary2,binarySub2);
                    }
                    if (oct1Mask == 255 && oct2Mask == 255 && oct3Mask < 255)
                    {
                        for (int i = 0; i < 8; i++)
                        {
                            netID4[i] = 0;
                        }
                        netID1 = compareBinary(binary1, binarySub1);
                        //broadIP1 = compareBinaryBroad(binary1,binarySub1);
                        netID2 = compareBinary(binary2, binarySub2);
                        //broadIP2 = compareBinaryBroad(binary2,binarySub2);
                        netID3 = compareBinary(binary3, binarySub3);
                        //broadIP3 = compareBinaryBroad(binary3,binarySub3);
                    }
                    if (oct1Mask == 255 && oct2Mask == 255 && oct3Mask == 255)
                    {
                        netID1 = compareBinary(binary1, binarySub1);
                        //broadIP1 = compareBinaryBroad(binary1,binarySub1);
                        netID2 = compareBinary(binary2, binarySub2);
                        //broadIP2 = compareBinaryBroad(binary2,binarySub2);
                        netID3 = compareBinary(binary3, binarySub3);
                        //broadIP3 = compareBinaryBroad(binary3,binarySub3);
                        netID4 = compareBinary(binary4, binarySub4);
                        //broadIP4 = compareBinaryBroad(binary4,binarySub4);
                    }

                    //finds Broadcast address
                    broadIP1 = compareBinaryBroad(binary1, binarySub1);
                    broadIP2 = compareBinaryBroad(binary2, binarySub2);
                    broadIP3 = compareBinaryBroad(binary3, binarySub3);
                    broadIP4 = compareBinaryBroad(binary4, binarySub4);

                    //calculates number of subnets on Subnet Mask
                    subTotal = subnetTotal(binarySub1, binarySub2, binarySub3, binarySub4);

                    //calculates number of usable hosts on Subnet Mask
                    hostsTotal = hostTotal(binarySub1, binarySub2, binarySub3, binarySub4);

                    //Changes Binary NetworkID to Decimal Network ID
                    newNetID1 = convertToDecimal(netID1);
                    newNetID2 = convertToDecimal(netID2);
                    newNetID3 = convertToDecimal(netID3);
                    newNetID4 = convertToDecimal(netID4);
                    broad1 = convertToDecimal(broadIP1);
                    broad2 = convertToDecimal(broadIP2);
                    broad3 = convertToDecimal(broadIP3);
                    broad4 = convertToDecimal(broadIP4);

                    //sends results output to ResultActivity
                    Intent startIntent = new Intent(MainActivity.this, ResultActivity.class);
                    startIntent.putExtra("parameter name", oct1ip);
                    startIntent.putExtra("parameter name2", oct2ip);
                    startIntent.putExtra("parameter name3", oct3ip);
                    startIntent.putExtra("parameter name4", oct4ip);
                    startIntent.putExtra("parameter name5", newNetID1);
                    startIntent.putExtra("parameter name6", newNetID2);
                    startIntent.putExtra("parameter name7", newNetID3);
                    startIntent.putExtra("parameter name8", newNetID4);
                    startIntent.putExtra("parameter name9", oct1Mask);
                    startIntent.putExtra("parameter name10", oct2Mask);
                    startIntent.putExtra("parameter name11", oct3Mask);
                    startIntent.putExtra("parameter name12", oct4Mask);
                    startIntent.putExtra("parameter name13", broad1);
                    startIntent.putExtra("parameter name14", broad2);
                    startIntent.putExtra("parameter name15", broad3);
                    startIntent.putExtra("parameter name16", broad4);
                    startIntent.putExtra("parameter name17", subTotal);
                    startIntent.putExtra("parameter name18", hostsTotal);
                    startIntent.putExtra("parameter name19", cidr);
                startActivity(startIntent);


                }        });}

        //converts integer into binary
        public int[] convertToBinary(int num)
        {
            //converts int to binary array
            int[]binary=new int[8];
            int index = 0;
            int temp;
            while(num >0){
                binary[index++] = num%2;
                num = num/2;
            }
            //Reverses array
            for(int i = 0;i<4;i++)
            {
               temp = binary[i];
               binary[i] = binary[7-i];
               binary[7-i]=temp;
            }
         return binary;
        }
        //Compares ip Octet to SubnetMask Octet in order to create NetID octet
        public int [] compareBinary(int []num1, int []num2)
        {
            int [] tempID= new int[8];
            for(int i=0;i<8;i++){
                if(num2[i]==1)
                    tempID[i]=num1[i];
                if(num2[i]==0)
                    tempID[i]=0;
            }
            return tempID;
        }

        //Compares ip Octet to SubnetMask Octet in order to create Broadcast Address
        public int [] compareBinaryBroad(int []num1, int[]num2)
        {
            int [] tempID= new int[8];
            for(int i=0;i<8;i++){
                if(num2[i]==1)
                    tempID[i]=num1[i];
                if(num2[i]==0)
                    tempID[i]=1;
            }
            return tempID;
        }

        //coverts binary into decimal
        public int convertToDecimal(int[] num)
        {
            //converts integer array to string
            String tempstring= Arrays.toString(num);

            //removes unnecessary string characters from string array
            String tempstring1 = tempstring.replace("[","");
            tempstring = tempstring1;
            tempstring1=tempstring.replace(",","");
            tempstring = tempstring1;
            tempstring1=tempstring.replace("]","");
            tempstring = tempstring1;
            tempstring1 = tempstring.replaceAll("\\s","");
            tempstring = tempstring1;

            //converts binary string to decimal integer
            int temp = Integer.parseInt(tempstring,2);

            return temp;
        }

        //Finds number of hosts in subnetMask
        public int subnetTotal(int[]num, int[]num2,int[]num3,int []num4)
        {
            double temp=0;
            double count=0;
            for(int i=0;i<8;i++){
                if(num[i]==1)
                    count++;
                }
            for(int i=0;i<8;i++){
                if(num2[i]==1)
                    count++;
            }
            for(int i=0;i<8;i++){
                if(num3[i]==1)
                    count++;
            }
            for(int i=0;i<8;i++){
                if(num4[i]==1)
                    count++;
            }
            temp=Math.pow(2,count);
            int temp1=(int)temp;
            return temp1;
        }

        //Finds number of subnets in SubnetMask
        public int hostTotal(int[] num, int[] num2,int[] num3, int[] num4)
        {
            double temp=0;
            double count=0;
            for(int i=0;i<8;i++) {
                if (num[i] == 0)
                    count++;
            }
            for(int i=0;i<8;i++){
                if(num2[i]==0)
                    count++;
                }
            for(int i=0;i<8;i++){
                if(num3[i]==0)
                    count++;
                }
            for(int i=0;i<8;i++) {
                if (num4[i] == 0)
                    count++;
                }
            temp = Math.pow(2,count);
            int temp1 = (int)temp;
            temp1 = temp1-2;
            return temp1;

        }
        //error checks first octet of IP address
        public boolean validateFirstIP(int firstOct)
        {
            int num1= firstOct;
            return num1 != 0 && 255 >= num1;
        }
        //error checks last octet of Subnet Mask
        public boolean validateLastMask(int oct4Mask)
        {
            int num1= oct4Mask;
            return 254 >= num1;
        }
        //error checks other octets of IP address
        public boolean validateBasicOct(int num1)
        {
            return num1 <= 255;
        }
        //error checks other octets of Subnet Mask
        public boolean validateMask(int num1)
        {
            return num1==0 || num1==128 || num1==192 || num1==224 || num1==240 || num1==248 || num1==252 || num1==252 || num1==254 || num1==255;
        }
        //error checks first octet of Subnet Mask
        public boolean validateFirstMask(int num1)
        {
            return num1==128 || num1==192 || num1==224 || num1==240 || num1==248 || num1==252 || num1==252 || num1==254 || num1==255;
        }
        //error checks CIDR
        public boolean validateCidr(int num1)
        {
            return num1 >=1 && num1 <=31;
        }
        //creates array from CIDR to create subnet mask
        public int[] changeCIDR(int num)
        {
        int temp1=0;
        int temp2=0;
        int temp3=0;
        int temp4=0;
        int[] tempArray={0,0,0,0};
        switch (num){
            case 1: temp1 = 128;
                    break;
            case 2: temp1 = 192;
                    break;
            case 3: temp1 = 224;
                    break;
            case 4: temp1 = 240;
                    break;
            case 5: temp1 = 248;
                    break;
            case 6: temp1 = 252;
                    break;
            case 7: temp1 = 254;
                    break;
            case 8: temp1 = 255;
                    break;
            case 9: temp1 = 255;
                    temp2 = 128;
                    break;
            case 10: temp1 = 255;
                     temp2 = 192;
                     break;
            case 11: temp1 = 255;
                     temp2 = 224;
                     break;
            case 12: temp1 = 255;
                     temp2 = 240;
                     break;
            case 13: temp1 = 255;
                     temp2 = 248;
                     break;
            case 14: temp1 = 255;
                     temp1 = 252;
                     break;
            case 15: temp1 = 255;
                     temp2 = 254;
                     break;
            case 16: temp1 = 255;
                     temp2 = 255;
                     break;
            case 17: temp1 = 255;
                     temp2 = 255;
                     temp3 = 128;
                     break;
            case 18: temp1 = 255;
                     temp2 = 255;
                     temp3 = 192;
                     break;
            case 19: temp1 = 255;
                     temp2 = 255;
                     temp3 = 224;
                     break;
            case 20: temp1 = 255;
                     temp2 = 255;
                     temp3 = 240;
                     break;
            case 21: temp1 = 255;
                     temp2 = 255;
                     temp3 = 248;
                     break;
            case 22: temp1 = 255;
                     temp2 = 255;
                     temp3 = 252;
                     break;
            case 23: temp1 = 255;
                     temp2 = 255;
                     temp3 = 254;
                     break;
            case 24: temp1 = 255;
                     temp2 = 255;
                     temp3 = 255;
                     break;
            case 25: temp1 = 255;
                     temp2 = 255;
                     temp3 = 255;
                     temp4 = 128;
                     break;
            case 26: temp1 = 255;
                     temp2 = 255;
                     temp3 = 255;
                     temp4 = 192;
                     break;
            case 27: temp1 = 255;
                     temp2 = 255;
                     temp3 = 255;
                     temp4 = 224;
                     break;
            case 28: temp1 = 255;
                     temp2 = 255;
                     temp3 = 255;
                     temp4 = 240;
                     break;
            case 29: temp1 = 255;
                     temp2 = 255;
                     temp3 = 255;
                     temp4 = 248;
                     break;
            case 30: temp1 = 255;
                     temp2 = 255;
                     temp3 = 255;
                     temp4 = 252;
                     break;
            case 31: temp1 = 255;
                     temp2 = 255;
                     temp3 = 255;
                     temp4 = 254;
                     break;
            case 32: temp1 = 255;
                     temp2 = 255;
                     temp3 = 255;
                     temp4 = 255;

        }
        tempArray[0]=temp1;
        tempArray[1]=temp2;
        tempArray[2]=temp3;
        tempArray[3]=temp4;
        return tempArray;
    }
    //finds CIDR from Subnet Mask
    public int convertMask2Cidr(int num1,int num2,int num3,int num4)
    {
        int temp = 0;
        if(num1==128 && num2==0 && num3==0 && num4==0)
            temp =1;
        if(num1==192 && num2==0 && num3==0 && num4==0)
            temp =2;
        if(num1==224 && num2==0 && num3==0 && num4==0)
            temp =3;
        if(num1==240 && num2==0 && num3==0 && num4==0)
            temp =4;
        if(num1==248 && num2==0 && num3==0 && num4==0)
            temp =5;
        if(num1==252 && num2==0 && num3==0 && num4==0)
            temp =6;
        if(num1==254 && num2==0 && num3==0 && num4==0)
            temp =7;
        if(num1==255 && num2==0 && num3==0 && num4==0)
            temp =8;
        if(num1==255 && num2==128 && num3==0 && num4==0)
            temp =9;
        if(num1==255 && num2==192 && num3==0 && num4==0)
            temp =10;
        if(num1==255 && num2==224 && num3==0 && num4==0)
            temp =11;
        if(num1==255 && num2==240 && num3==0 && num4==0)
            temp =12;
        if(num1==255 && num2==248 && num3==0 && num4==0)
            temp =13;
        if(num1==255 && num2==252 && num3==0 && num4==0)
            temp =14;
        if(num1==255 && num2==254 && num3==0 && num4==0)
            temp =15;
        if(num1==255 && num2==255 && num3==0 && num4==0)
            temp =16;
        if(num1==255 && num2==255 && num3==128 && num4==0)
            temp =17;
        if(num1==255 && num2==255 && num3==192 && num4==0)
            temp =18;
        if(num1==255 && num2==255 && num3==224 && num4==0)
            temp =19;
        if(num1==255 && num2==255 && num3==240 && num4==0)
            temp =20;
        if(num1==255 && num2==255 && num3==248 && num4==0)
            temp =21;
        if(num1==255 && num2==255 && num3==252 && num4==0)
            temp =22;
        if(num1==255 && num2==255 && num3==254 && num4==0)
            temp =23;
        if(num1==255 && num2==255 && num3==255 && num4==0)
            temp =24;
        if(num1==255 && num2==255 && num3==255 && num4==128)
            temp =25;
        if(num1==255 && num2==255 && num3==255 && num4==192)
            temp =26;
        if(num1==255 && num2==255 && num3==255 && num4==224)
            temp =27;
        if(num1==255 && num2==255 && num3==255 && num4==240)
            temp =28;
        if(num1==255 && num2==255 && num3==255 && num4==248)
            temp =29;
        if(num1==255 && num2==255 && num3==255 && num4==252)
            temp =30;
        if(num1==255 && num2==255 && num3==255 && num4==254)
            temp =31;

        return temp;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.credits,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent startIntent = new Intent(MainActivity.this,AboutActivity.class);
        startActivity(startIntent);

        return super.onOptionsItemSelected(item);
    }
}
