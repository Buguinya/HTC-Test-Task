package com.htc.hightechnologiescentertest;

import android.annotation.SuppressLint;
import android.content.ClipData;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CompanyInfoActivity extends AppCompatActivity {

    private ListView mEmployeesLv;
    private TextView mCompanyNameTv;
    private TextView mCompanyAgeTv;
    private TextView mCompanyCompetences;

    private EmployeesAdapter mAdapter;

    private List<Employee> mEmployees;
    private Company mCompany;
    private JsonResponse mResponse;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_company_info);

        mEmployeesLv = findViewById(R.id.employees_iv);
        mCompanyNameTv = findViewById(R.id.name_of_company_tv);
        mCompanyAgeTv = findViewById(R.id.age_of_company_tv);
        mCompanyCompetences = findViewById(R.id.competences_of_company_tv);

        mAdapter = new EmployeesAdapter(this, R.layout.employee_item);
        mEmployeesLv.setAdapter(mAdapter);

        loadData();
    }

    private class EmployeesAdapter extends ArrayAdapter<Item> {

        private TextView mNameTv;
        private TextView mPhoneTv;
        private TextView mSkillsTv;

        public EmployeesAdapter(Context context, int resource) {
            super(context, resource);

        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

            @SuppressLint("ViewHolder") final View view = getLayoutInflater().inflate(R.layout.employee_item, null);
            final Item item = getItem(position);
            mNameTv = view.findViewById(R.id.name_of_employee_tv);
            mNameTv.setText(item.name);
            mPhoneTv = view.findViewById(R.id.phone_of_employee_tv);
            mPhoneTv.setText(item.phone);
            mSkillsTv = view.findViewById(R.id.skills_of_employee_tv);
            mSkillsTv.setText(Arrays.toString(item.skills));
            return view;
        }
    }

    private class Item {

        private String name;
        private String phone;
        private String[] skills;

        public Item(String name, String phone, String[] skills) {
            this.name = name;
            this.phone = phone;
            this.skills = skills;
        }
    }

    private void loadData(){
        App.getCompanyApi().getJSONCompany().enqueue(new Callback<JsonResponse>() {
            @Override
            public void onResponse(Call<JsonResponse> call, Response<JsonResponse> response) {
                Log.d("Load", "onResponse: ");
                mResponse = response.body();
                if (mResponse != null){
                    mCompany = mResponse.getCompany();
                    mCompanyNameTv.setText(mCompany.getName());
                    mCompanyAgeTv.setText(mCompany.getAge());
                    mCompanyCompetences.setText(mCompany.getCompetences().toString());
                    mEmployees = mCompany.getEmployees();
                    Collections.sort(mEmployees, new Comparator<Employee>() {
                        @Override
                        public int compare(Employee o1, Employee o2) {
                            if (o1.getName().compareTo(o2.getName()) > 0){
                                return 1;
                            }else
                            return -1;
                        }
                    });
                    for (Employee employee: mEmployees) {
                        mAdapter.add(new Item(employee.getName(), employee.getPhoneNumber(), employee.getSkills()));
                    }
                }
            }

            @Override
            public void onFailure(Call<JsonResponse> call, Throwable t) {
                Log.d("Load", "onFailure: " + t);

            }
        });
    }

}
