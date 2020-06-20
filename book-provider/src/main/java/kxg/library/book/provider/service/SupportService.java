package kxg.library.book.provider.service;

import kxg.library.book.request.FindMajorRequest;
import kxg.library.book.response.FindSupportResponse;

import java.util.List;

/**
 * 要写注释呀
 */
public interface SupportService {
    FindSupportResponse findSupport(FindMajorRequest request);
}
