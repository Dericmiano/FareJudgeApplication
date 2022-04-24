package com.example.farejudgeapplication.models;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class SharedViewModel extends ViewModel {
    private final MutableLiveData<Host> selectedItem = new MutableLiveData<>();
    private boolean isEdit;

    public void selectItem(Host host){ selectedItem.setValue(host);}
    public LiveData<Host> getSelectedItem(){return selectedItem;}

    public void setIsEdit(boolean isEdit){this.isEdit = isEdit;}
    public boolean getIsEdit(){return isEdit;}


}
