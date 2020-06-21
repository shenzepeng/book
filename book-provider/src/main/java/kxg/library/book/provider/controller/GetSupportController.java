package kxg.library.book.provider.controller;

import kxg.library.book.provider.config.SzpJsonResult;
import kxg.library.book.provider.service.SupportService;
import kxg.library.book.request.FindMajorRequest;
import kxg.library.book.response.FindSupportResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 要写注释呀
 */
@RestController
@RequestMapping("support")
public class GetSupportController {
    @Autowired
    private SupportService supportService;
    @PostMapping
    public SzpJsonResult<FindSupportResponse> getSupport(@RequestBody FindMajorRequest request){
        return SzpJsonResult.ok(supportService.findSupport(request));
    }
}
