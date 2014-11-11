package com.readersdigest.onepass.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.readersdigest.onepass.util.StringUtils;

/**
 * The Class OnePassForwardAction.
 *
 * @author shsingh
 */
public class OnePassForwardAction extends Action {

    /*
     * (non-Javadoc)
     *
     * @see org.apache.struts.action.Action#execute(org.apache.struts.action. ActionMapping, org.apache.struts.action.ActionForm,
     * javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
     */
    @Override
    public final ActionForward execute(final ActionMapping mapping, final ActionForm form, final HttpServletRequest request, final HttpServletResponse response)
            throws Exception {

        String sourceId = request.getParameter("sourceId");
        String prodId = "";
        
        if(sourceId == null || "".equals(sourceId)) {
            prodId = "RDO";
        } else {
            prodId = StringUtils.getProdIdBySource(sourceId);
        }
        
        return mapping.findForward("success_"+prodId);
    }

}
