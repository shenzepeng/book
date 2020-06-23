package kxg.library.book.provider.service;

import kxg.library.book.request.FindReportRequest;
import kxg.library.book.response.FindReportResponse;

/**
 * 要写注释呀
 */
public interface ReportService {
    FindReportResponse findReport(FindReportRequest reportRequest);
}
