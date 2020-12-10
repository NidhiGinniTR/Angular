package com_helper_Reporting;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;


public class ListenersClass extends ExtentManager implements ITestListener{
	@Override
	public void onTestStart(ITestResult result) {
		test=extent.createTest(result.getName());
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		if(result.getStatus()==ITestResult.SUCCESS) {
			test.log(Status.PASS, MarkupHelper.createLabel(result.getName()+" - test case is passed", ExtentColor.GREEN));
		}
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		if(result.getStatus()==ITestResult.FAILURE) {
			test.log(Status.FAIL, MarkupHelper.createLabel(result.getName()+" - test case is failed", ExtentColor.RED)); 
			test.log(Status.FAIL, MarkupHelper.createLabel(result.getThrowable()+" - test case failed", ExtentColor.RED));
			childTest.fail(MarkupHelper.createLabel(result.getMethod().getMethodName()+" is failed", ExtentColor.RED));
		}
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		if(result.getStatus()==ITestResult.SKIP) {
			test.log(Status.SKIP, MarkupHelper.createLabel(result.getName()+" - test case is skipped", ExtentColor.YELLOW));
		}
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
		
	}

	@Override
	public void onStart(ITestContext context) {
		
		
	}

	@Override
	public void onFinish(ITestContext context) {
		
		
	}

}
