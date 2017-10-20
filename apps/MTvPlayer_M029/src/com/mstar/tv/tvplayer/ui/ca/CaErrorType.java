
package com.mstar.tv.tvplayer.ui.ca;

public class CaErrorType {
    public static enum CA_NOTIFY {
        ST_CA_MESSAGE_CANCEL_TYPE, ST_CA_MESSAGE_BADCARD_TYPE, ST_CA_MESSAGE_EXPICARD_TYPE, ST_CA_MESSAGE_INSERTCARD_TYPE, ST_CA_MESSAGE_NOOPER_TYPE, ST_CA_MESSAGE_BLACKOUT_TYPE, ST_CA_MESSAGE_OUTWORKTIME_TYPE, ST_CA_MESSAGE_WATCHLEVEL_TYPE, ST_CA_MESSAGE_PAIRING_TYPE, ST_CA_MESSAGE_NOENTITLE_TYPE, ST_CA_MESSAGE_DECRYPTFAIL_TYPE, ST_CA_MESSAGE_NOMONEY_TYPE, ST_CA_MESSAGE_ERRREGION_TYPE, ST_CA_MESSAGE_NEEDFEED_TYPE, ST_CA_MESSAGE_ERRCARD_TYPE, ST_CA_MESSAGE_UPDATE_TYPE, ST_CA_MESSAGE_LOWCARDVER_TYPE, ST_CA_MESSAGE_VIEWLOCK_TYPE, ST_CA_MESSAGE_MAXRESTART_TYPE, ST_CA_MESSAGE_FREEZE_TYPE, ST_CA_MESSAGE_CALLBACK_TYPE, ST_CA_MESSAGE_CURTAIN_TYPE, ST_CA_MESSAGE_CARDTESTSTART_TYPE, ST_CA_MESSAGE_CARDTESTFAILD_TYPE, ST_CA_MESSAGE_CARDTESTSUCC_TYPE, ST_CA_MESSAGE_NOCALIBOPER_TYPE, ST_CA_MESSAGE_STBLOCKED_TYPE, ST_CA_MESSAGE_STBFREEZE_TYPE,
    }

    public enum RETURN_CODE {
        ST_CA_RC_OK(0), ST_CA_RC_UNKNOWN(1), ST_CA_RC_POINTER_INVALID(2), ST_CA_RC_CARD_INVALID(3), ST_CA_RC_PIN_INVALID(
                4), ST_CA_RC_DATASPACE_SMALL(6), ST_CA_RC_CARD_PAIROTHER(7), ST_CA_RC_DATA_NOT_FIND(
                8), ST_CA_RC_PROG_STATUS_INVALID(9), ST_CA_RC_CARD_NO_ROOM(10), ST_CA_RC_WORKTIME_INVALID(
                11), ST_CA_RC_IPPV_CANNTDEL(12), ST_CA_RC_CARD_NOPAIR(13), ST_CA_RC_WATCHRATING_INVALID(
                14), ST_CA_RC_CARD_NOTSUPPORT(15), ST_CA_RC_DATA_ERROR(16), ST_CA_RC_FEEDTIME_NOT_ARRIVE(
                17), ST_CA_RC_CARD_TYPEERROR(18), ST_CA_RC_CAS_FAILED(32), ST_CA_RC_OPER_FAILED(33);

        private int retCode;

        private RETURN_CODE(int value) {
            this.retCode = value;
        }

        public int getRetCode() {
            return retCode;
        }
    }

    public enum CA_CARD_STATE {
        ST_CA_SC_OUT, ST_CA_SC_REMOVING, ST_CA_SC_INSERTING, ST_CA_SC_IN, ST_CA_SC_ERROR, ST_CA_SC_UPDATE, ST_CA_SC_UPDATE_ERR,
    }

}