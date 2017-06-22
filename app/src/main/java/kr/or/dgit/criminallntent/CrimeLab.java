package kr.or.dgit.criminallntent;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class CrimeLab {
    private static CrimeLab sCimeLab;

    private List<Crime> mCrimes;

    public static CrimeLab get(Context context){
        if(sCimeLab == null){
            sCimeLab = new CrimeLab(context);
        }
        return sCimeLab;
    }

    private CrimeLab(Context context){
        mCrimes = new ArrayList<>();
        for(int i=0; i<100;i++){
            Crime crime = new Crime();
            crime.setTitle("범죄 #"+i);
            crime.setSolved(i%2 ==0);
            mCrimes.add(crime);
        }
    }

    public List<Crime> getCrimes(){
        return mCrimes;
    }
    public Crime getCrime(UUID id){
        for(Crime crime : mCrimes){
            if(crime.getId().equals(id)){
                return crime;
            }
        }
        return null;
    }
}
