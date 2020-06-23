package kxg.library.book.provider.controller;

import kxg.library.book.request.FindReportRequest;
import kxg.library.book.response.FindReportResponse;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 要写注释呀
 */
@RestController
@RequestMapping("report")
public class ReportController {

    @PostMapping
    public FindReportResponse findReport(@RequestBody FindReportRequest reportRequest){

    }
}
