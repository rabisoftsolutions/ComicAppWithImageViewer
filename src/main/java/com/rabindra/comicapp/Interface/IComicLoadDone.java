package com.rabindra.comicapp.Interface;

import com.rabindra.comicapp.Model.Comic;

import java.util.List;

public interface IComicLoadDone {
    void onComicLoadDoneListener(List<Comic> comicList);
}
