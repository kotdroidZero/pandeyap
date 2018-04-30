package com.example.pandyap.pandyap;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context mContext;

    private LayoutInflater mLayoutInflater;

    private List<PojoDataModel> list;

    public RecyclerAdapter(Context mContext) {
        this.mContext = mContext;
        mLayoutInflater = LayoutInflater.from(mContext);
        list = new ArrayList<>();
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new EmployeeHolder(mLayoutInflater.inflate(R.layout.row_employee, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        EmployeeHolder employeeHolder = ((EmployeeHolder) holder);
        PojoDataModel pojoDataModel = list.get(position);

        employeeHolder.tvId.setText(pojoDataModel.getEmployeeId());
        employeeHolder.tvName.setText(pojoDataModel.getName());
        employeeHolder.tvDepartment.setText(pojoDataModel.getDepartment());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public void updateProduct(List<PojoDataModel> pojoDataModels) {
        list.clear();
        list.addAll(pojoDataModels);
    }

    class EmployeeHolder extends RecyclerView.ViewHolder {
        TextView tvName, tvId, tvDepartment;


        EmployeeHolder(View itemView) {
            super(itemView);
            tvDepartment = itemView.findViewById(R.id.tvEmployeeDepartment);
            tvName = itemView.findViewById(R.id.tvEmployeeName);
            tvId = itemView.findViewById(R.id.tvEmployeeId);
        }
    }
}
