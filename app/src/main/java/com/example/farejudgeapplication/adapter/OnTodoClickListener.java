package com.example.farejudgeapplication.adapter;

import com.example.farejudgeapplication.models.Host;

public interface OnTodoClickListener {
    void onTodoClick(Host host);
    void onTodoDeleteButtonClick(Host host);
    void onTodoUpdateButtonClick(Host host);

}
